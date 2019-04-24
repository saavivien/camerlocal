/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.GenericDao;
import com.camerlocal.camerlocal.service.GenericService;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 * @param <T>
 * @param <Id>
 * @param <Dao>
 */
public abstract class GenericServiceImpl<T extends Object, Id extends Serializable, Dao extends GenericDao<T, Id>>
        implements GenericService<T, Id, Dao> {

    Class<T> entityClass;
    protected Dao genericDao;

    public GenericServiceImpl(Dao genericDao) {
        this.genericDao = genericDao;
//        this is aimed to extract the entity class
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    public Dao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(Dao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public T findById(Id id) throws Exception {
        try {
            return genericDao.findById(id);
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to find entity " + entityClass.getName(), e);
        }
    }

    @Override
    public List<T> findAll() throws Exception {
        try {
            return genericDao.findAll();
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to find All " + entityClass.getName(), e);
        }
    }

    @Override
    @Transactional
    public T create(T t) throws Exception {
        try {
            return genericDao.create(t);
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to create a " + entityClass.getName(), e);
        }
    }

    @Override
    @Transactional
    public void delete(T t) throws Exception {
        try {
            genericDao.delete(t);
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to delete a " + entityClass.getName(), e);
        }
    }

    @Override
    @Transactional
    public T update(T t) throws Exception {
        try {
            return genericDao.update(t);
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to update a" + entityClass.getName(), e);
        }
    }

//	@Override
//	public Long countAll() throws Exception {
//		return genericDao.countAll();
//	}
}
