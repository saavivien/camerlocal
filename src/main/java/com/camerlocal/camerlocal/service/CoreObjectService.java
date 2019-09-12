/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.service;

import com.camerlocal.camerlocal.dao.CoreObjectDao;
import com.camerlocal.camerlocal.entities.CoreObject;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.exception.CamerLocalServiceException;

/**
 *
 * @author vivien saa
 * @param <CO>
 * @param <Dao>
 */
public interface CoreObjectService<CO extends CoreObject, Dao extends CoreObjectDao<CO>> extends GenericService<CO, Long, Dao> {

    public CO create(CO c, User userCreator) throws CamerLocalServiceException;

    public CO update(CO c, User userEditor) throws CamerLocalServiceException;

    public CO archive(CO c, User userArchivist) throws CamerLocalServiceException;
}
