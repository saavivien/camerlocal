/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.config;

import com.camerlocal.camerlocal.dao.RoleDao;
import com.camerlocal.camerlocal.dao.UserDao;
import com.camerlocal.camerlocal.dao.UserRoleDao;
import com.camerlocal.camerlocal.entities.Role;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.entities.UserRole;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        //check if it is the first deployemnt of this API
        Role roleTest = roleDao.findRoleByName(Constants.ROLE_ADMIN);

        if (roleTest == null) {
            //roles creation
            Role adminRole = new Role();
            Role agentRole = new Role();
            Role clientRole = new Role();
            adminRole.setRoleName(Constants.ROLE_ADMIN);
            agentRole.setRoleName(Constants.ROLE_AGENT);
            clientRole.setRoleName(Constants.ROLE_CLIENT);

            roleDao.create(adminRole);
            roleDao.create(agentRole);
            roleDao.create(clientRole);

            //admin creation
            User firstUser = new User();
            firstUser.setCreationDate(new Date());
            firstUser.setFirstName(Constants.DEFAULT_ADMIN_NAME);
            firstUser.setIsActive(Boolean.TRUE);
            firstUser.setName(Constants.DEFAULT_ADMIN_NAME);
            firstUser.setEmail(Constants.DEFAULT_ADMIN_USERNAME);
            firstUser.setPassword(bcryptEncoder.encode(Constants.DEFAULT_ADMIN_PASSWORD));
            userDao.create(firstUser);
            UserRole userRole = new UserRole();
            userRole.setRole(adminRole);
            userRole.setUser(firstUser);
            userRoleDao.create(userRole);
        }

    }

}
