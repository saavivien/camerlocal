/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.FeatureLineDao;
import com.camerlocal.camerlocal.entities.FeatureLine;
import com.camerlocal.camerlocal.service.FeatureLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class FeatureLineServiceImpl
        extends GenericServiceImpl<FeatureLine, Long, FeatureLineDao>
        implements FeatureLineService {

    @Autowired
    public FeatureLineServiceImpl(FeatureLineDao featureLineDao) {
        super(featureLineDao);
    }

}
