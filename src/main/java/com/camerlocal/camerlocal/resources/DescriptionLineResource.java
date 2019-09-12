/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.controller.UserController;
import com.camerlocal.camerlocal.entities.DescriptionLine;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 *
 * @author vivien saa
 */
public class DescriptionLineResource extends ResourceSupport {

    public DescriptionLineResource(DescriptionLine descriptionLine) {
//        add(linkTo(methodOn(UserController.class).findById()).withSelfRel(id));
//        add(linkTo(methodOn(UserController.class).findAll()).withRel("full_list"));
//        add(linkTo(methodOn(UserController.class).update(entityClass)).withRel("update"));

    }

}
