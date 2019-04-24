/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.MarkDao;
import com.camerlocal.camerlocal.entities.Mark;
import com.camerlocal.camerlocal.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class MarkServiceImpl
        extends GenericServiceImpl<Mark, Long, MarkDao>
        implements MarkService {

    @Autowired
    public MarkServiceImpl(MarkDao markDao) {
        super(markDao);
    }

}
