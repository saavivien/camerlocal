/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.controller.UserController;
import com.camerlocal.camerlocal.entities.User;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 *
 * @author vivien saa
 */
public class UserResource extends ResourceSupport {

    private final User user;

    public UserResource(User user) throws Exception {
        this.user = user;
        final long id = user.getId();
        add(linkTo(UserController.class).withRel("users"));
        add(linkTo(methodOn(UserController.class).findLocalisationById(id)).withSelfRel());
//        add(linkTo(methodOn(UserController.class).findAllUser()).withRel("all"));
    }

    public User getUser() {
        return user;
    }
//    
}