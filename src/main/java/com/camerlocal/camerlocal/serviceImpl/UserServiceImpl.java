/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.UserDao;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class UserServiceImpl
        extends CoreObjectServiceImpl<User, UserDao>
        implements UserService {

    public UserServiceImpl(UserDao userDao) {
        super(userDao);
    }

}