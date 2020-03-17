/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.entities.User;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author vivien saa
 */
public class UserResource extends RepresentationModel {

    private User user;
    private String image;

    public UserResource(User user, Boolean withProfileImage) {
        this.user = user;
        //do not serve image for every request
        if (user.getProfileImage() != null && withProfileImage) {
            String encodeBase64 = Base64.getEncoder().encodeToString(user.getProfileImage().getImageByte());
            String extention = FilenameUtils.getExtension(user.getProfileImage().getImageName());
            this.image = "data:image/" + extention + ";base64," + encodeBase64;
        }
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

    public String getImage() {
        return image;
    }

}
