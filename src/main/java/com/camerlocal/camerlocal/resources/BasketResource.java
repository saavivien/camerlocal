/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.entities.Basket;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author vivien saa
 */
public class BasketResource extends RepresentationModel {

    public BasketResource(Basket basket) {

//        add(linkTo(methodOn(UserController.class).findById()).withSelfRel(id));
//        add(linkTo(methodOn(UserController.class).findAll()).withRel("full_list"));
//        add(linkTo(methodOn(UserController.class).update(entityClass)).withRel("update"));
    }
}
