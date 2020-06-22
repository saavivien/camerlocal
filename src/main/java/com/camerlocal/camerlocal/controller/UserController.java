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
import com.camerlocal.camerlocal.service.ImageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author vivien saa
 */
@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,
        methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS},
        allowedHeaders = "*")
public class UserController extends CamerLocalRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper pojoConverter;

    /**
     * Client creation, can be performed by a clent
     *
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/client")
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    public ResponseEntity<Void> createUserClient(@RequestBody User user) throws Exception {
        User c = userService.createClient(user);
        if (null == c) {
            return ResponseEntity.noContent().build();
        }
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(c.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * find a client with his id
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or #id==principal.id")
    public ResponseEntity<UserResource> findUserById(@PathVariable("id") Long id) {
        try {
            User user = userService.findById(id);
            if (null != user) {
                return new ResponseEntity<>(new UserResource(user), HttpStatus.OK);
            }
            throw new RecordNotFoundException("no user found with id :" + id);
        } catch (CamerLocalServiceException ex) {
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }
    }

    /**
     * user creation to be used if the front end doen't handle pictures
     *
     * @param user
     * @return
     */
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        try {
            User u = userService.create(user, getAuthenticatedUser());
            if (null == u) {
                return ResponseEntity.noContent().build();
            }
            final URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(u.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();

        } catch (CamerLocalServiceException ex) {
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }
    }

    /**
     * User creation for front end that handle pictures.Can be performed only by
     * an Admin
     *
     * @param user
     * @param imageFile
     * @return
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PostMapping(value = "/userprofile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserResource> createUserWithProfile(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws JsonProcessingException, IOException {
        try {
            User userModel = pojoConverter.readValue(user, User.class);
            Image image = null;
            if (null != imageFile) {
                image = new Image();
                image.setCreationDate(new Date());
                image.setImageName(imageFile.getOriginalFilename());
                image.setImageByte(imageFile.getBytes());
            }
            User u = userService.create(userModel, image, getAuthenticatedUser());

            if (null == u) {
                return ResponseEntity.noContent().build();
            }
            final URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(u.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();

        } catch (CamerLocalServiceException ex) {
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }

    }

    /**
     * user update to be used if the front end doen't handle pictures
     *
     * @param id
     * @param user
     * @return
     */
//    @PutMapping(value = "/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<Void> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
//        try {
//            User u = userService.update(id, user, getAuthenticatedUser());
//            if (null != u) {
//                return ResponseEntity.ok().build();
//            }
//            return ResponseEntity.noContent().build();
//        } catch (CamerLocalServiceException ex) {
//            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
//        }
//
//    }
    /**
     * User update for front end that handle pictures. Can be performed either
     * by standart connected user or by the admin
     *
     * @param id
     * @param user
     * @param imageFile
     * @return
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PutMapping(value = "/userprofile/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or #id==principal.id")
    public ResponseEntity<Void> updateStandardUserWithProfile(
            @PathVariable("id") Long id,
            @RequestParam(value = "user") String user,
            @RequestParam(value = "image", required = false) MultipartFile imageFile)
            throws JsonProcessingException, IOException {
        try {
            User userModel = pojoConverter.readValue(user, User.class);

            Image image = null;
            if (null != imageFile) {
                image = new Image();
                image.setCreationDate(new Date());
                image.setImageName(imageFile.getOriginalFilename());
                image.setImageByte(imageFile.getBytes());
            }
//            User u = userService.create(userModel, image, getAuthenticatedUser());
            User u = userService.update(id, userModel, image, getAuthenticatedUser());
            if (null != u) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.noContent().build();
        } catch (CamerLocalServiceException ex) {
            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
        }
    }

    /**
     * findAll users method
     *
     * @return
     */
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

//    @GetMapping(path = {"/email"})
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<UserResource> findUserByUserName(@PathVariable("email") String email) {
//        try {
//            User user = userService.findUserByUsername(email);
//            if (null != user) {
//                return new ResponseEntity<>(new UserResource(user), HttpStatus.OK);
//            }
//            throw new RecordNotFoundException("no user found with email :" + email);
//        } catch (CamerLocalServiceException ex) {
//            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
//            throw new InternalServerException(INTERNAL_SERVER_ERROR_MESSAGE + ex);
//        }
//    }
}
