/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.CoreObjectEditionDao;
import com.camerlocal.camerlocal.entities.CoreObjectEdition;
import com.camerlocal.camerlocal.service.CoreObjectEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class CoreObjectEditionServiceImpl
        extends GenericServiceImpl<CoreObjectEdition, Long, CoreObjectEditionDao>
        implements CoreObjectEditionService {

    @Autowired
    public CoreObjectEditionServiceImpl(CoreObjectEditionDao coreObjectEditionDao) {
        super(coreObjectEditionDao);
    }

}
