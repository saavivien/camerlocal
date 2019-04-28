/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.dao;

import com.camerlocal.camerlocal.entities.Role;
import com.camerlocal.camerlocal.serviceImpl.utils.CamerLocalDaoException;

/**
 *
 * @author vivien saa
 */
public interface RoleDao extends GenericDao<Role, Long> {

    public Role findRoleByName(String roleName) throws CamerLocalDaoException;
}
