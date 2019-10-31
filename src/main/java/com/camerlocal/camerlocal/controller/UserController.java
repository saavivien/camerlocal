/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import static com.camerlocal.camerlocal.config.Constants.ROLE_ADMIN;
import com.camerlocal.camerlocal.entities.Role;
import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.resources.UserResource;
import com.camerlocal.camerlocal.service.UserService;
import com.camerlocal.camerlocal.exception.CamerLocalServiceException;
import com.camerlocal.camerlocal.exception.InternalServerException;
import com.camerlocal.camerlocal.exception.RecordNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping(value = "/client")
    public ResponseEntity<UserResource> createUserClient(@RequestBody User user) throws Exception {
        User u = userService.createClient(user);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/client").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(new UserResource(u));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<UserResource> createUser(@RequestBody User user, @RequestBody List<Role> roles) {
        try {
            User u = userService.create(user, roles, getAuthenticatedUser());
            final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(u.getId()).toUri();
            return ResponseEntity.created(uri).body(new UserResource(u));
        } catch (CamerLocalServiceException ex) {
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }

    }

    @PutMapping
    public ResponseEntity<UserResource> updateUser(@RequestBody User user, @RequestBody List<Role> roles) {
        User u;
        try {
            u = userService.update(user, roles, getAuthenticatedUser());
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

}
