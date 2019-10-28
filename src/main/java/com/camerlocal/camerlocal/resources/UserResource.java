/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.controller.UserController;
import com.camerlocal.camerlocal.entities.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.hateoas.RepresentationModel;


/**
 *
 * @author vivien saa
 */
public class UserResource extends RepresentationModel {

    private User user;

    public UserResource(User user) {
        this.user = user;
        try {
//            add(linkTo(methodOn(UserController.class).findUserById(user.getId())).withSelfRel());
//            add(linkTo(methodOn(UserController.class).updateUser(user, null)).withRel("update"));
//            add(linkTo(methodOn(UserController.class).findAllUsers()).withRel("full_list"));
        } catch (Exception ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUser() {
        return user;
    }

}
