/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.ProductStateDao;
import com.camerlocal.camerlocal.entities.ProductState;
import com.camerlocal.camerlocal.service.ProductStateService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class ProductStateServiceImpl
        extends GenericServiceImpl<ProductState, Long, ProductStateDao>
        implements ProductStateService {

    public ProductStateServiceImpl(ProductStateDao productStateDao) {
        super(productStateDao);
    }

}