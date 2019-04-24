/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.PeriodDao;
import com.camerlocal.camerlocal.entities.Periods;
import com.camerlocal.camerlocal.service.PeriodService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class PeriodServiceImpl
        extends GenericServiceImpl<Periods, Long, PeriodDao>
        implements PeriodService {

    public PeriodServiceImpl(PeriodDao periodDao) {
        super(periodDao);
    }

}
