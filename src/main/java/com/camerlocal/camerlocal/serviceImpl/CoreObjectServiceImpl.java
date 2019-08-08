/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.CoreObjectDao;
import com.camerlocal.camerlocal.entities.CoreObject;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.service.CoreObjectService;
import com.camerlocal.camerlocal.utils.CamerLocalDaoException;
import com.camerlocal.camerlocal.utils.CamerLocalServiceException;
import java.util.Date;

/**
 *
 * @author vivien saa
 * @param <CO>
 * @param <Dao>
 */
public abstract class CoreObjectServiceImpl<CO extends CoreObject, Dao extends CoreObjectDao<CO>>
        extends GenericServiceImpl<CO, Long, Dao>
        implements CoreObjectService<CO, Dao> {

    public CoreObjectServiceImpl(Dao coreObjectDao) {
        super(coreObjectDao);
    }

    @Override
    public CO create(CO c, User userCreator) throws CamerLocalServiceException {
        logger.debug("Service creating" + entityClass.getName());

        Date date = new Date();
        c.setCreationDate(date);
        c.setModificationDate(date);
        c.setIsActive(true);
        c.setUserCreator(userCreator);
//        User user = userDao.create(client);
//        UserRole userRole = new UserRole();
//        userRole.setUser(user);
//        Role role = roleDao.findRoleByName(Constants.ROLE_CLIENT);
//        userRole.setRole(role);
//        userRoleDao.create(userRole);
//        return user;
        try {
            return genericDao.create(c);
        } catch (CamerLocalDaoException e) {
            logger.error("create exception in" + entityClass.getName(), entityClass);
            throw new CamerLocalServiceException("unable to create a " + entityClass.getName(), e);
        }
    }

    @Override
    public CO update(CO c, User userEditor) throws CamerLocalServiceException {
        logger.debug("Service updating" + entityClass.getName());
        try {
            return genericDao.update(c);
        } catch (CamerLocalDaoException e) {
            logger.error("update exception in" + entityClass.getName(), entityClass);
            throw new CamerLocalServiceException("unable to update a" + entityClass.getName(), e);
        }
    }
}
