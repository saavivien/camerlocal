/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.controller.UserController;
import com.camerlocal.camerlocal.entities.Category;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 *
 * @author vivien saa
 */
public class CategoryResource extends ResourceSupport {

    public CategoryResource(Category category) {

//        add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
//        add(linkTo(methodOn(UserController.class).findAll()).withRel("full_list"));
//        add(linkTo(methodOn(UserController.class).update(category)).withRel("update"));
    }
}
