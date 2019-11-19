/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.entities.Product;
import com.camerlocal.camerlocal.exception.CamerLocalServiceException;
import com.camerlocal.camerlocal.resources.ProductResource;
import com.camerlocal.camerlocal.service.ProductService;
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
 * @author Ngnawen
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,
        methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS},
        allowedHeaders = "*")
@RequestMapping(value = "/api/product")
public class ProductController extends CamerLocalRestController{
    
    @Autowired
    private ProductService productService;
    
     @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody Product product) throws Exception {
        Product p = productService.create(product);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductResource(p));
    }
    
    
//    @Secured("")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResource> findProductById(@PathVariable("id") Long id) throws Exception {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new ProductResource(product));
    }

//    @Secured("")
    @PutMapping
    public ResponseEntity<ProductResource> updateProduct(@RequestBody Product product) throws Exception {
        Product p = productService.findById(product.getId());
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.update(product);
        final ProductResource productResource = new ProductResource(product);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(productResource);

    }

//    @Secured("")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) throws Exception {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.delete(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @GetMapping
    public ResponseEntity<CollectionModel<ProductResource>> findAllProduct() throws Exception {
        List<ProductResource> listProductResources = new ArrayList<>();
            try {
           productService.findAll().forEach(prod-> listProductResources.add(new ProductResource(prod)));
            } catch (CamerLocalServiceException ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("======================"+listProductResources+"====================");
        return ResponseEntity.ok(new CollectionModel<>(listProductResources));
    }
    
}
