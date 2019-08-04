/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.resources.UserResource;
import com.camerlocal.camerlocal.service.UserService;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author vivien saa
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Secured("")
    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody User user) throws Exception {
        User u = userService.create(user);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserResource(u));
    }

//    @Secured("")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> findUserById(@PathVariable("id") Long id) throws Exception {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new UserResource(user));
    }

//    @Secured("")
    @PutMapping
    public ResponseEntity<UserResource> updateUser(@RequestBody User user) throws Exception {
        User u = userService.findById(user.getId());
        System.out.println("********************** update method ************************");
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.update(user);
        final UserResource userResource = new UserResource(user);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(userResource);

    }

//    @Secured("")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) throws Exception {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @Secured("")
    @GetMapping
    public ResponseEntity<Resources<UserResource>> findAllUser() throws Exception {
//        List<UserResource> listUserResources = userService.findAll().stream().map(UserResource::new).collect(Collectors.toList());
        List<UserResource> listUserResources = new ArrayList<>();
        for (User u : userService.findAll()) {
            listUserResources.add(new UserResource(u));
        }
        final Resources< UserResource> resources = new Resources<>(listUserResources);
        if (listUserResources.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    @PostMapping(value = "/client")
    public ResponseEntity<UserResource> createUserClient(@RequestBody User user) throws Exception {
        User u = userService.createClient(user);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/client").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(new UserResource(u));
    }
}
