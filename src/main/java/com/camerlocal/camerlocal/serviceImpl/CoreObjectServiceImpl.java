/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.CoreObjectDao;
import com.camerlocal.camerlocal.entities.CoreObject;
import com.camerlocal.camerlocal.service.CoreObjectService;

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

}
