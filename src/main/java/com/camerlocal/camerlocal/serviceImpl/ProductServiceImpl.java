/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.ProductDao;
import com.camerlocal.camerlocal.entities.Product;
import com.camerlocal.camerlocal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
@Service
public class ProductServiceImpl
        extends CoreObjectServiceImpl<Product, ProductDao>
        implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        super(productDao);
    }

}
