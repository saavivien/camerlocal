/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author vivien saa
 */
@Entity
public class ProductCategory implements Serializable {

    @Id
    @Column(name = "id_product_category")
    private Long idProductCategory;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Category category;

    public Long getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(Long idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

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
