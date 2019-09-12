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
import com.camerlocal.camerlocal.utils.Action;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;
import com.camerlocal.camerlocal.exception.CamerLocalServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    public UserDetails loadUserByUsername(String userName) {
        UserDetails ud = null;
        try {
            ud = userDao.findUserByUserName(userName);
        } catch (Exception ex) {
//            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ud;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User createClient(User client) throws CamerLocalServiceException {
        try {
            setMetaData(client, client, Action.ADD);
            User user = userDao.create(client);
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            Role role = roleDao.findRoleByName(Constants.ROLE_CLIENT);
            userRole.setRole(role);
            userRoleDao.create(userRole);
            return user;
        } catch (Exception ex) {
            throw new CamerLocalServiceException("unable to create client " + client.getName(), ex);
        }
    }

    @Override
    public User create(User user, List<Role> roles, User userCreator) throws CamerLocalServiceException {
        try {
            setMetaData(user, userCreator, Action.ADD);
            User u = userDao.create(user);
//            roles.stream().map(r -> { 
//                UserRole ur = new UserRole();
//                ur.setUser(user);
//                ur.setRole(r);
//                userRoleDao.create(ur);
//            });

            for (Role r : roles) {
                UserRole ur = new UserRole();
                ur.setUser(user);
                ur.setRole(r);
                userRoleDao.create(ur);
            }
            return u;
        } catch (CamerLocalDaoException ex) {
            throw new CamerLocalServiceException("unable to create user " + user.getName());
        }

    }

    @Override
    public User update(User user, List<Role> roles, User userEditor) throws CamerLocalServiceException {
        try {
            setMetaData(user, userEditor, Action.EDIT);
            userRoleDao.deleteUserRoleByUser(user.getId());
            User u = userDao.update(user);
            for (Role r : roles) {
                UserRole ur = new UserRole();
                ur.setUser(user);
                ur.setRole(r);
                userRoleDao.create(ur);
            }
            return u;
        } catch (CamerLocalDaoException ex) {
            throw new CamerLocalServiceException("unable to update user " + user.getName());
        }

    }

}
