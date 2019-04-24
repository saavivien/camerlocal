/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.ImageDao;
import com.camerlocal.camerlocal.entities.Image;
import com.camerlocal.camerlocal.service.ImageService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class ImageServiceImpl
        extends CoreObjectServiceImpl<Image, ImageDao>
        implements ImageService {

    public ImageServiceImpl(ImageDao imageDao) {
        super(imageDao);
    }

}
