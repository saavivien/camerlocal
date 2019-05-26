/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.daoImpl;

import com.camerlocal.camerlocal.dao.RoleDao;
import com.camerlocal.camerlocal.entities.Role;
import com.camerlocal.camerlocal.utils.CamerLocalDaoException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vivien saa
 */
@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Long>
        implements RoleDao {

    @Override
    public Role findRoleByName(String roleName) throws CamerLocalDaoException {
        logger.debug("Dao getting" + Role.class);
        Query query = getEntityManager().createNamedQuery("role_find_role_by_role_name");
        query.setParameter("roleName", roleName);
        try {
            return (Role) query.getSingleResult();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }
    }

}
