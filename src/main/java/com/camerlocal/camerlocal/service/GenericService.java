/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.service;

import com.camerlocal.camerlocal.dao.GenericDao;
import com.camerlocal.camerlocal.entities.BaseObject;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.utils.CamerLocalServiceException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vivien saa
 * @param <T>
 * @param <Id>
 * @param <Dao>
 */
public interface GenericService<T extends BaseObject, Id extends Serializable, Dao extends GenericDao<T, Id>> {

    public T findById(Id id) throws CamerLocalServiceException;

    public List<T> findAll() throws CamerLocalServiceException;

    public T create(T t) throws CamerLocalServiceException;

    public T update(T t) throws CamerLocalServiceException;

    public void delete(T t) throws CamerLocalServiceException;
}
