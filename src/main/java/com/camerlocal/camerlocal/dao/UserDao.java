/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.dao;

import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;
import com.camerlocal.camerlocal.exception.CamerLocalException;

/**
 *
 * @author vivien saa
 */
public interface UserDao extends CoreObjectDao<User> {

    public User findUserByUserName(String userName) throws CamerLocalDaoException;
}
