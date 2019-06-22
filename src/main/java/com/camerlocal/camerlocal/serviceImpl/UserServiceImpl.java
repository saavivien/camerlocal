/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.config.Constants;
import com.camerlocal.camerlocal.dao.RoleDao;
import com.camerlocal.camerlocal.dao.UserDao;
import com.camerlocal.camerlocal.dao.UserRoleDao;
import com.camerlocal.camerlocal.entities.Role;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.entities.UserRole;
import com.camerlocal.camerlocal.service.UserService;
import com.camerlocal.camerlocal.utils.CamerLocalServiceException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    private final UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            return userDao.findUserByUserName(userName);
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new UsernameNotFoundException("No user named " + userName);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User createClient(User client) throws CamerLocalServiceException {
        try {
            Date date = new Date();
            client.setCreationDate(date);
            client.setModificationDate(date);
            client.setIsActive(true);
            client.setUserCreator(client);
            User user = userDao.create(client);
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            Role role = roleDao.findRoleByName(Constants.ROLE_CLIENT);
            userRole.setRole(role);
            userRoleDao.create(userRole);
            return user;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new CamerLocalServiceException("No user named " + client.getName());
        }
    }

}
