/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author vivien saa
 */
@Entity
public class Category extends CoreObject {

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<ProductCategory> listProductCategorys;

    public List<ProductCategory> getListProductCategorys() {
        return listProductCategorys;
    }

    public void setListProductCategorys(List<ProductCategory> listProductCategorys) {
        this.listProductCategorys = listProductCategorys;
    }

}
