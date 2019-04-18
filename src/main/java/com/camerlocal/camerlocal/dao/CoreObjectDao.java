/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.dao;

import com.camerlocal.camerlocal.entities.CoreObject;

/**
 *
 * @author vivien saa
 * @param <co>
 */
public interface CoreObjectDao<co extends CoreObject> extends GenericDao<co, Long> {

}
