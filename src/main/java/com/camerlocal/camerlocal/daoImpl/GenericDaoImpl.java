/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.daoImpl;

import com.camerlocal.camerlocal.dao.GenericDao;
import com.camerlocal.camerlocal.utils.CamerLocalDaoException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.slf4j.Logger;

/**
 *
 * @author vivien saa
 * @param <T>
 * @param <Id>
 */
public abstract class GenericDaoImpl<T extends Object, Id extends Serializable> implements GenericDao<T, Id> {

    protected final Logger logger;
    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;
    private CriteriaBuilder cb;
    private CriteriaQuery<T> cq;

    public GenericDaoImpl() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
        logger = org.slf4j.LoggerFactory.getLogger(entityClass);
    }

    @Override
    public T findById(Id id) throws CamerLocalDaoException {
        logger.debug("Dao getting" + entityClass.getName());
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public List<T> findAll() throws CamerLocalDaoException {
        logger.debug("Dao Getting all" + entityClass.getName());
        cb = entityManager.getCriteriaBuilder();
        cq = cb.createQuery(entityClass);
        cq.from(entityClass);
        try {
            return entityManager.createQuery(cq).getResultList();

        } catch (Exception e) {
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public T create(T t) throws CamerLocalDaoException {
        logger.debug("Dao Creating" + entityClass.getName());
        try {
            entityManager.persist(t);
            return t;
        } catch (Exception e) {
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public T update(T t) throws CamerLocalDaoException {
        logger.debug("Dao Updating" + entityClass.getName());
        try {
            return entityManager.merge(t);
        } catch (Exception e) {
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void delete(T t) throws CamerLocalDaoException {
        logger.debug("Dao Deleting" + entityClass.getName());
        try {
            entityManager.remove(t);
        } catch (Exception e) {
            throw new CamerLocalDaoException(e.getMessage(), e.getCause());
        }

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public CriteriaBuilder getCb() {
        return cb;
    }

    public void setCb(CriteriaBuilder cb) {
        this.cb = cb;
    }

    public CriteriaQuery<T> getCq() {
        return cq;
    }

    public void setCq(CriteriaQuery<T> cq) {
        this.cq = cq;
    }

}
