/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author vivien saa
 */
@Entity
public class ProviderProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_provider_product")
    private Long idProviderProduct;

    @ManyToOne
    private Provider provider;

    @ManyToOne
    private Product product;

    public Long getIdProviderProduct() {
        return idProviderProduct;
    }

    public void setIdProviderProduct(Long idProviderProduct) {
        this.idProviderProduct = idProviderProduct;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
