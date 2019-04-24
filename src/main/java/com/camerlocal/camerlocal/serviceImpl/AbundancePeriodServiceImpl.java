/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.AbundancePeriodDao;
import com.camerlocal.camerlocal.entities.AbundancePeriod;
import com.camerlocal.camerlocal.service.AbundancePeriodService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class AbundancePeriodServiceImpl extends GenericServiceImpl<AbundancePeriod, Long, AbundancePeriodDao>
        implements AbundancePeriodService {

    public AbundancePeriodServiceImpl(AbundancePeriodDao abundancePeriodDao) {
        super(abundancePeriodDao);
    }

}
