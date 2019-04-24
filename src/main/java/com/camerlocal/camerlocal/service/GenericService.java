/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.service;

import com.camerlocal.camerlocal.dao.GenericDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vivien saa
 * @param <T>
 * @param <Id>
 * @param <Dao>
 */
public interface GenericService<T extends Object, Id extends Serializable, Dao extends GenericDao<T, Id>> {

    public T findById(Id id) throws Exception;

    public List<T> findAll() throws Exception;

    public T create(T t) throws Exception;

    public T update(T t) throws Exception;

    public void delete(T t) throws Exception;
}
