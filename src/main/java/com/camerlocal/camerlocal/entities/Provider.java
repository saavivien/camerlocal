/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author vivien saa
 */
@Entity
public class Provider extends CoreObject {

    private String phone1;

    private String phone2;

    private String email;

    @Column(name = "residence_city")
    private String residenceCity;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    private List<ProviderProduct> listProviderProducts;

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(String residenceCity) {
        this.residenceCity = residenceCity;
    }

    public List<ProviderProduct> getListProviderProducts() {
        return listProviderProducts;
    }

    public void setListProviderProducts(List<ProviderProduct> listProviderProducts) {
        this.listProviderProducts = listProviderProducts;
    }

}
