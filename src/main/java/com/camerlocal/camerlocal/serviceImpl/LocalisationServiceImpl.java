/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.LocalisationDao;
import com.camerlocal.camerlocal.entities.Localisation;
import com.camerlocal.camerlocal.service.LocalisationService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class LocalisationServiceImpl
        extends GenericServiceImpl<Localisation, Long, LocalisationDao>
        implements LocalisationService {

    public LocalisationServiceImpl(LocalisationDao localisationDao) {
        super(localisationDao);
    }

}
