/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.daoImpl;

import com.camerlocal.camerlocal.dao.UserDao;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.serviceImpl.utils.CamerLocalDaoException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vivien saa
 */
@Repository
public class UserDaoImpl extends CoreObjectDaoImpl<User>
        implements UserDao {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User findUserByUserName(String userName) throws Exception {
        logger.debug("Getting user by username " + userName);
        Query query = getEntityManager().createNamedQuery("user_find_user_by_user_name");
        query.setParameter("userName", userName);
        try {
            return (User) query.getSingleResult();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());

        }
    }
}
