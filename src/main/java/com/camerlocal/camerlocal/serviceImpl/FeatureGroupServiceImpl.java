/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.FeatureGroupDao;
import com.camerlocal.camerlocal.entities.FeatureGroup;
import com.camerlocal.camerlocal.service.FeatureGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class FeatureGroupServiceImpl
        extends GenericServiceImpl<FeatureGroup, Long, FeatureGroupDao>
        implements FeatureGroupService {

    @Autowired
    public FeatureGroupServiceImpl(FeatureGroupDao featureGroupDao) {
        super(featureGroupDao);
    }

}
