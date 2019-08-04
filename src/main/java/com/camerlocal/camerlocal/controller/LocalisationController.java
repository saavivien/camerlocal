/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.entities.Localisation;
import com.camerlocal.camerlocal.service.LocalisationService;
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
@RequestMapping(value = "/localisation")
public class LocalisationController {

    @Autowired
    private LocalisationService localisationService;

    @PostMapping
    public ResponseEntity<Localisation> createLocalisation(@RequestBody Localisation localisation) throws Exception {
        Localisation l = localisationService.create(localisation);
        return new ResponseEntity<>(l, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localisation> findLocalisationById(@PathVariable("id") Long id) throws Exception {
        Localisation localisation = localisationService.findById(id);
        if (localisation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(localisation, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Localisation> updateLocalisationService(@RequestBody Localisation localisation) throws Exception {
        Localisation l = localisationService.findById(localisation.getIdLocalisation());
        if (l == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        localisationService.update(localisation);
        return new ResponseEntity<>(localisation, HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Localisation> deleteLocalisationService(@PathVariable("id") Long id) throws Exception {
        Localisation localisation = localisationService.findById(id);
        if (localisation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        localisationService.delete(localisation);
        return new ResponseEntity<>(localisation, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Localisation>> findAllLocalisation() throws Exception {
        List<Localisation> listLocalisation = localisationService.findAll();
        if (listLocalisation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listLocalisation, HttpStatus.OK);
    }

}
