/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.daoImpl;

import com.camerlocal.camerlocal.dao.UserRoleDao;
import com.camerlocal.camerlocal.entities.UserRole;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vivien saa
 */
@Repository
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole, Long>
        implements UserRoleDao {

    @Override
    public void deleteUserRoleByUser(Long userId) throws CamerLocalDaoException {
        try {
            getEntityManager().createNamedQuery("user_role_delete_user_role_by_user")
                    .setParameter("userId", userId).executeUpdate();
        } catch (Exception e) {
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }

    }

}
