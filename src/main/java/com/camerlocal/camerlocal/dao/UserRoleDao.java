/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.dao;

import com.camerlocal.camerlocal.entities.UserRole;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;

/**
 *
 * @author vivien saa
 */
public abstract interface UserRoleDao extends GenericDao<UserRole, Long> {

    public void deleteUserRoleByUser(Long userId) throws CamerLocalDaoException;
}
