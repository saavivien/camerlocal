/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.controller.GenericRestController;
import com.camerlocal.camerlocal.controller.UserController;
import com.camerlocal.camerlocal.entities.User;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

/**
 *
 * @author vivien saa
 */
@Component
public class UserResource extends CamerLocalCoreResource<User> {

    public UserResource() {
        super();
    }

    public UserResource(User t) {
        super(t);
//        add(linkTo(methodOn(UserController.class).findById()).withSelfRel(id));
        add(linkTo(methodOn(UserController.class).findAll()).withRel("full_list"));
//        add(linkTo(methodOn(UserController.class).update(entityClass)).withRel("update"));

    }

    @Override
    public UserResource getInstance(User t) {
        return new UserResource(t);
    }
}
