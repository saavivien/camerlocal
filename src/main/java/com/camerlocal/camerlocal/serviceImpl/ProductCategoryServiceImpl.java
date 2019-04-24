/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.ProductCategoryDao;
import com.camerlocal.camerlocal.entities.ProductCategory;
import com.camerlocal.camerlocal.service.ProductCategoryService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class ProductCategoryServiceImpl
        extends GenericServiceImpl<ProductCategory, Long, ProductCategoryDao>
        implements ProductCategoryService {

    public ProductCategoryServiceImpl(ProductCategoryDao productCategoryDao) {
        super(productCategoryDao);
    }

}
