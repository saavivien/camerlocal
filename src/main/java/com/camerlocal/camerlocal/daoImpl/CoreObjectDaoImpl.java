/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.daoImpl;

import com.camerlocal.camerlocal.dao.CoreObjectDao;
import com.camerlocal.camerlocal.entities.CoreObject;

/**
 *
 * @author vivien saa
 * @param <CO>
 */
public abstract class CoreObjectDaoImpl<CO extends CoreObject> extends GenericDaoImpl<CO, Long>
        implements CoreObjectDao<CO> {

}
