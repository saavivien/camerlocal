/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.entities.Image;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.resources.UserResource;
import com.camerlocal.camerlocal.service.UserService;
import com.camerlocal.camerlocal.exception.CamerLocalServiceException;
import com.camerlocal.camerlocal.exception.InternalServerException;
import com.camerlocal.camerlocal.exception.RecordNotFoundException;
import com.camerlocal.camerlocal.utils.ImageUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author vivien saa
 */
@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,
        methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS},
        allowedHeaders = "*")
public class UserController extends CamerLocalRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper pojoConverter;

    @PostMapping(value = "/client")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserResource> createUserClient(@RequestBody User user) throws Exception {
        User u = userService.createClient(user);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/client").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(new UserResource(u));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserResource> findUserById(@PathVariable("id") Long id) {
        try {
            User user = userService.findById(id);
            if (null != user) {
                return new ResponseEntity<>(new UserResource(user), HttpStatus.OK);
            }
            throw new RecordNotFoundException("no user found with id :" + id);
        } catch (CamerLocalServiceException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserResource> createUser(@RequestBody User user) {
        try {
            System.out.println("============================" + user.getRoles() + "===================================");
            User u = userService.create(user, getAuthenticatedUser());
            final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(u.getId()).toUri();
            return ResponseEntity.created(uri).body(new UserResource(u));
        } catch (CamerLocalServiceException ex) {
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }
    }

    @PostMapping(value = "/userprofile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserResource> createUserWithProfile(@RequestParam(value = "user") String user, @RequestParam(value = "image") MultipartFile file) throws JsonProcessingException, IOException {
        try {
            User userModel = pojoConverter.readValue(user, User.class);
            User u = userService.create(userModel, getAuthenticatedUser());

            Image image = new Image();
            image.setCreationDate(new Date());
            image.setImageName(file.getOriginalFilename());
            image.setImageByte(file.getBytes());
            u.setProfileImage(image);

            u = userService.create(u, getAuthenticatedUser());
            return ResponseEntity.ok(new UserResource(u));
        } catch (CamerLocalServiceException ex) {
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }

    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserResource> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            User u = userService.update(id, user, getAuthenticatedUser());
            if (null != u) {
                final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
                return ResponseEntity.created(uri).body(new UserResource(u));
            }
            throw new RecordNotFoundException("no user found with id :" + user.getId());
        } catch (CamerLocalServiceException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }

    }

    @PutMapping(value = "/userprofile/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserResource> updateUserWithProfile(@PathVariable("id") Long id, @RequestParam(value = "user") String user, @RequestParam(value = "image", required = false) MultipartFile file) throws JsonProcessingException, IOException {
        try {
            User userModel = pojoConverter.readValue(user, User.class);
            if (file != null) {
                Image image = new Image();
                image.setCreationDate(new Date());
                image.setImageName(file.getOriginalFilename());
                image.setImageByte(file.getBytes());
                userModel.setProfileImage(image);
            }
            User u = userService.update(id, userModel, getAuthenticatedUser());
            return ResponseEntity.ok(new UserResource(u));
        } catch (CamerLocalServiceException ex) {
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CollectionModel<UserResource>> findAllUsers() {
        List<UserResource> listResources = new ArrayList<>();
        try {
            userService.findAll().forEach(t -> listResources.add((new UserResource(t))));
        } catch (CamerLocalServiceException ex) {
            Logger.getLogger(CamerLocalRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResponseEntity.ok(new CollectionModel<>(listResources));
    }

    @GetMapping(path = {"/email"})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserResource> findUserByUserName(@PathVariable("email") String email) {
        try {
            User user = userService.findUserByUsername(email);
            if (null != user) {
                return new ResponseEntity<>(new UserResource(user), HttpStatus.OK);
            }
            throw new RecordNotFoundException("no user found with email :" + email);
        } catch (CamerLocalServiceException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }
    }

}
