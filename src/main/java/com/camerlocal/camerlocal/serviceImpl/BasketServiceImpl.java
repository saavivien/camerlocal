/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.BasketDao;
import com.camerlocal.camerlocal.entities.Basket;
import com.camerlocal.camerlocal.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class BasketServiceImpl
        extends GenericServiceImpl<Basket, Long, BasketDao>
        implements BasketService {

    @Autowired
    public BasketServiceImpl(BasketDao basketDao) {
        super(basketDao);
    }

}
