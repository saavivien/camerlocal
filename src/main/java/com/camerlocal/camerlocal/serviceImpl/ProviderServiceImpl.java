/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.serviceImpl;

import com.camerlocal.camerlocal.dao.ProviderDao;
import com.camerlocal.camerlocal.entities.Provider;
import com.camerlocal.camerlocal.service.ProviderService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class ProviderServiceImpl
        extends CoreObjectServiceImpl<Provider, ProviderDao>
        implements ProviderService {

    public ProviderServiceImpl(ProviderDao providerDao) {
        super(providerDao);
    }

}
