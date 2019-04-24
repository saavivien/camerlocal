/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.CategoryDao;
import com.camerlocal.camerlocal.entities.Category;
import com.camerlocal.camerlocal.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class CategoryServiceImpl
        extends CoreObjectServiceImpl<Category, CategoryDao>
        implements CategoryService {

    public CategoryServiceImpl(CategoryDao categoryDao) {
        super(categoryDao);
    }

}
