/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.service;

import com.camerlocal.camerlocal.dao.UserDao;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.serviceImpl.utils.CamerLocalServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author vivien saa
 */
public interface UserService extends CoreObjectService<User, UserDao> {

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

    public User createClient(User client) throws CamerLocalServiceException;
}
