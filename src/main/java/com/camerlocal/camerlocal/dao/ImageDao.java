/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.dao;

import com.camerlocal.camerlocal.entities.Image;
import com.camerlocal.camerlocal.exception.CamerLocalDaoException;

/**
 *
 * @author vivien saa
 */
public interface ImageDao extends GenericDao<Image, Long> {

    public Image findImageByUser(long userId) throws CamerLocalDaoException;
}
