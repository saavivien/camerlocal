/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.service;

import com.camerlocal.camerlocal.dao.UserDao;
import com.camerlocal.camerlocal.entities.Role;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.exception.CamerLocalServiceException;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author vivien saa
 */
public interface UserService extends CoreObjectService<User, UserDao> {

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

    public User createClient(User client) throws CamerLocalServiceException;

    public User create(User user, List<Role> roles, User userCreator) throws CamerLocalServiceException;

    public User update(User user, List<Role> roles, User userEditor) throws CamerLocalServiceException;
}
