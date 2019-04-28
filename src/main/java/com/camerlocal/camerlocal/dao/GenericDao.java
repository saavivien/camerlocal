/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.dao;

import com.camerlocal.camerlocal.serviceImpl.utils.CamerLocalDaoException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vivien saa
 * @param <T>
 * @param <Id>
 */
public interface GenericDao<T extends Object, Id extends Serializable> {

    public T findById(Id id) throws CamerLocalDaoException;

    public List<T> findAll() throws CamerLocalDaoException;

    public T create(T t) throws CamerLocalDaoException;

    public T update(T t) throws CamerLocalDaoException;

    public void delete(T t) throws CamerLocalDaoException;

}
