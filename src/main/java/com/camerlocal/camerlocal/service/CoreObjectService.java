/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.service;

import com.camerlocal.camerlocal.dao.CoreObjectDao;
import com.camerlocal.camerlocal.entities.CoreObject;

/**
 *
 * @author vivien saa
 * @param <CO>
 * @param <Dao>
 */
public interface CoreObjectService<CO extends CoreObject, Dao extends CoreObjectDao<CO>> extends GenericService<CO, Long, Dao> {

}
