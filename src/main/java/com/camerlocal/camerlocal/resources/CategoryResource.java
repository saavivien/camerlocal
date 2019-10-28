/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.entities.Category;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author vivien saa
 */
public class CategoryResource extends RepresentationModel {

    public CategoryResource(Category category) {

//        add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
//        add(linkTo(methodOn(UserController.class).findAll()).withRel("full_list"));
//        add(linkTo(methodOn(UserController.class).update(category)).withRel("update"));
    }
}
