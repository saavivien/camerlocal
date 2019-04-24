/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.DescriptionLineDao;
import com.camerlocal.camerlocal.entities.DescriptionLine;
import com.camerlocal.camerlocal.service.DescriptionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class DescriptionLineServiceImpl
        extends GenericServiceImpl<DescriptionLine, Long, DescriptionLineDao>
        implements DescriptionLineService {

    @Autowired
    public DescriptionLineServiceImpl(DescriptionLineDao descriptionLineDao) {
        super(descriptionLineDao);
    }

}
