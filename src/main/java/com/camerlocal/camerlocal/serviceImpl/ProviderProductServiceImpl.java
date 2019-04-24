/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.ProviderProductDao;
import com.camerlocal.camerlocal.entities.ProviderProduct;
import com.camerlocal.camerlocal.service.ProviderProductService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class ProviderProductServiceImpl
        extends GenericServiceImpl<ProviderProduct, Long, ProviderProductDao>
        implements ProviderProductService {

    public ProviderProductServiceImpl(ProviderProductDao providerProductDao) {
        super(providerProductDao);
    }

}
