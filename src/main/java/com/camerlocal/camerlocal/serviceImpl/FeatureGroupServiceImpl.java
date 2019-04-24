/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.FeatureGroupDao;
import com.camerlocal.camerlocal.entities.FeatureGroup;
import com.camerlocal.camerlocal.service.FeatureGroupService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class FeatureGroupServiceImpl
        extends GenericServiceImpl<FeatureGroup, Long, FeatureGroupDao>
        implements FeatureGroupService {

    public FeatureGroupServiceImpl(FeatureGroupDao featureGroupDao) {
        super(featureGroupDao);
    }

}
