/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.entities.Category;
import com.camerlocal.camerlocal.resources.CategoryResource;
import com.camerlocal.camerlocal.service.CategoryService;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,
        methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS},
        allowedHeaders = "*")
@RequestMapping(value = "/api/category")
public class CategoryController extends CamerLocalRestController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResource> createCategory(@RequestBody Category category) throws Exception {
        Category c = categoryService.create(category);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(c.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoryResource(c));
    }

//    @Secured("")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResource> findCategoryById(@PathVariable("id") Long id) throws Exception {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new CategoryResource(category));
    }

//    @Secured("")
    @PutMapping
    public ResponseEntity<CategoryResource> updateCategory(@RequestBody Category category) throws Exception {
        Category c = categoryService.findById(category.getId());
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.update(category);
        final CategoryResource categoryResource = new CategoryResource(category);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(categoryResource);

    }

//    @Secured("")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) throws Exception {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @Secured("")
    @GetMapping
    public ResponseEntity<CollectionModel<CategoryResource>> findAllCategory() throws Exception {
        List<CategoryResource> listCategoryResources = new ArrayList<>();
        categoryService.findAll().forEach((Category cat) -> {
            try {
                listCategoryResources.add(new CategoryResource(cat));
            } catch (Exception ex) {
                Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        if (listCategoryResources.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        final CollectionModel<CategoryResource> resources = new CollectionModel<>(listCategoryResources);
        return ResponseEntity.ok(resources);
    }
}
