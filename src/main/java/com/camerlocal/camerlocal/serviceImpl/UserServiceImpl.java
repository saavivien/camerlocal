/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.config.Constants;
import com.camerlocal.camerlocal.dao.RoleDao;
import com.camerlocal.camerlocal.dao.UserDao;
import com.camerlocal.camerlocal.entities.Role;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.service.UserService;
import com.camerlocal.camerlocal.utils.Action;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;
import com.camerlocal.camerlocal.exception.CamerLocalServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl
        extends CoreObjectServiceImpl<User, UserDao>
        implements UserService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            User user = userDao.findUserByUserName(userName);
            if (null == user) {
                throw new UsernameNotFoundException("no user found with userName " + userName);
            }
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            user.getListUserRoles().forEach((UserRole userRole) -> {
//                authorities.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
//            });
//            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
            return user;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User createClient(User client) throws CamerLocalServiceException {
        try {
            /* saving Client first, allows to set him as the user creator. this is used in order to avoid 
            "CascadeType=Persist" that will generate a problem when it will come to create a user by 
            another user existing yet 
             */
            userDao.create(client);
            setMetaData(client, client, Action.ADD);
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            List<Role> roles = new ArrayList<>();
            roles.add(roleDao.findRoleByName(Constants.ROLE_CLIENT));
            client.setRoles(roles);
            User user = userDao.update(client);
            return user;
        } catch (CamerLocalDaoException ex) {
            throw new CamerLocalServiceException("unable to create client " + client.getName(), ex);
        }
    }

    @Override
    public User create(User user, User userCreator) throws CamerLocalServiceException {
        try {
            setMetaData(user, userCreator, Action.ADD);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userDao.create(user);
        } catch (CamerLocalDaoException ex) {
            throw new CamerLocalServiceException("unable to create user " + user.getName());
        }
    }

    @Override
    public User update(Long id, User user, User userEditor) throws CamerLocalServiceException {
        try {
            User u = userDao.findById(id);
            u.setTitle(user.getTitle());
            u.setFirstName(user.getFirstName());
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPhone1(user.getPhone1());
            u.setPhone2(user.getPhone2());
            u.setRoles(user.getRoles());
            u.setProfileImage(user.getProfileImage());

            setMetaData(u, userEditor, Action.EDIT);

            return userDao.update(u);

        } catch (CamerLocalDaoException ex) {
            throw new CamerLocalServiceException("unable to update user " + user.getName());
        }
    }

    @Override
    public User findUserByUsername(String userName) throws CamerLocalServiceException {

        try {
            User user = userDao.findUserByUserName(userName);
            if (null == user) {
                throw new UsernameNotFoundException("no user found with userName " + userName);
            }
            return user;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
