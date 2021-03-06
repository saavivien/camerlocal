/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.UserRoleDao;
import com.camerlocal.camerlocal.entities.UserRole;
import com.camerlocal.camerlocal.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class UserRoleServiceImpl
        extends GenericServiceImpl<UserRole, Long, UserRoleDao>
        implements UserRoleService {

    @Autowired
    public UserRoleServiceImpl(UserRoleDao userRoleDao) {
        super(userRoleDao);
    }

}
