/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.daoImpl;

import com.camerlocal.camerlocal.dao.UserDao;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vivien saa
 */
@Repository
public class UserDaoImpl extends CoreObjectDaoImpl<User>
        implements UserDao {

    @Override
    public User findUserByUserName(String userName) throws Exception {
        List results = getEntityManager().createNamedQuery("user_find_user_by_user_name").
                setParameter("userName", userName).getResultList();
        try {
            return results.isEmpty() ? null : (User) results.get(0);
        } catch (Exception e) {
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }
    }
}
