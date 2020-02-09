/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.exception.CamerLocalServiceException;
import com.camerlocal.camerlocal.resources.RoleResource;
import com.camerlocal.camerlocal.service.RoleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vivien saa
 */
@RestController
@RequestMapping(value = "/api/role")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,
        methods = {RequestMethod.GET, RequestMethod.OPTIONS},
        allowedHeaders = "*")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CollectionModel<RoleResource>> findAllRoles() {
        List<RoleResource> listResources = new ArrayList<>();
        try {
            roleService.findAll().forEach(t -> listResources.add((new RoleResource(t))));
        } catch (CamerLocalServiceException ex) {
        }
        return ResponseEntity.ok(new CollectionModel<>(listResources));
    }
}
