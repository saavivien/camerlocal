/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.entities.Product;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author vivien saa
 */
public class ProductResource extends RepresentationModel {
    private Product product;

    public ProductResource(Product product) {
        this.product=product;
        

//        add(linkTo(methodOn(UserController.class).findById()).withSelfRel(id));
//        add(linkTo(methodOn(UserController.class).findAll()).withRel("full_list"));
//        add(linkTo(methodOn(UserController.class).update(entityClass)).withRel("update"));
    }

    public Product getProduct() {
        return product;
    }
    

}
