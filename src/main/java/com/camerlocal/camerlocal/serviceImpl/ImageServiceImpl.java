/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.ImageDao;
import com.camerlocal.camerlocal.entities.Image;
import com.camerlocal.camerlocal.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class ImageServiceImpl
        extends GenericServiceImpl<Image, Long, ImageDao>
        implements ImageService {

    @Autowired
    public ImageServiceImpl(ImageDao imageDao) {
        super(imageDao);
    }

}
