/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.entities.User;
import com.camerlocal.camerlocal.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        User u = userService.create(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

//    @Secured("")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findLocalisationById(@PathVariable("id") Long id) throws Exception {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @Secured("")
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
        User u = userService.findById(user.getId());
        System.out.println("********************** update method ************************");
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

//    @Secured("")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteLocalisationService(@PathVariable("id") Long id) throws Exception {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @Secured("")
    @GetMapping
    public ResponseEntity<List<User>> findAllUser() throws Exception {
        List<User> listUser = userService.findAll();
        if (listUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @PostMapping(value = "/client")
    public ResponseEntity<User> createUserClient(@RequestBody User user) throws Exception {
        User u = userService.createClient(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }
}
