/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.RoleDao;
import com.camerlocal.camerlocal.entities.Role;
import com.camerlocal.camerlocal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class RoleServiceImpl
        extends GenericServiceImpl<Role, Long, RoleDao>
        implements RoleService {

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        super(roleDao);
    }

}
