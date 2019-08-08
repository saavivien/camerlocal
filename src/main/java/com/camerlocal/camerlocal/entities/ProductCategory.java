/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author vivien saa
 */
@Entity
public class ProductCategory extends BaseObject {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Category category;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
