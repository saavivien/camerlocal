/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.dao.GenericDao;
import com.camerlocal.camerlocal.entities.BaseObject;
import com.camerlocal.camerlocal.resources.GenericResource;
import com.camerlocal.camerlocal.service.GenericService;
import com.camerlocal.camerlocal.utils.CamerLocalServiceException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author vivien saa
 * @param <T>
 * @param <D>
 * @param <R>
 */
public class GenericRestController<T extends BaseObject, D extends GenericDao<T, Long>, R extends GenericResource<T>> {

    private GenericService<T, Long, D> service;
    protected Class<T> entityClass;
    protected static final String BASE_URL = "/api";
    protected final R resource;

    public GenericRestController(GenericService<T, Long, D> service, R resource) {
        this.service = service;
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
        this.resource = resource;

    }

    @GetMapping
//    @PreAuthorize("this.checkAuthorization()")
    public ResponseEntity<Resources<R>> findAll() {
        List<R> listResources = new ArrayList<>();
        try {
            for (T t : getService().findAll()) {
                listResources.add((R) resource.getInstance(t));
            }
        } catch (Exception ex) {
            Logger.getLogger(GenericRestController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ResponseEntity.ok(new Resources<>(listResources));
    }

//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    @PreAuthorize("this.checkAuthorization()")
//    public ResponseEntity<DTO> create(@RequestBody
//            @Valid T request, BindingResult errors) {
//        validate(request, errors);
//        if (errors.hasErrors()) {
//            return new ResponseEntity<DTO>(errorParser.processValidationErrors(errors), HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//        return ResponseEntity.ok(restService().create(request));
//    }
//
//    @RequestMapping(value = "/{requestId}", method = RequestMethod.GET)
//    @ResponseBody
//    @PreAuthorize("this.checkAuthorization()")
//    public ResponseEntity<DTO> get(@PathVariable Integer requestId) {
//        return forExistingRequest(requestId, id
//                -> ResponseEntity.ok(restService().getById(id)));
//    }
//
//    @RequestMapping(value = "/{requestId}", method = RequestMethod.PUT)
//    @ResponseBody
//    @PreAuthorize("this.checkAuthorization()")
//    public ResponseEntity<DTO> modify(@PathVariable Integer requestId, @RequestBody
//            @Valid
//            final T request, final BindingResult errors) {
//        return forExistingRequest(requestId, id -> {
//            validate(request, errors);
//            if (errors.hasErrors()) {
//                return new ResponseEntity<DTO>(errorParser.processValidationErrors(errors), HttpStatus.UNPROCESSABLE_ENTITY);
//            }
//            return ResponseEntity.ok(restService().update(id, request));
//        });
//    }
//
//    @RequestMapping(value = "/{requestId}", method = RequestMethod.DELETE)
//    @ResponseBody
//    @PreAuthorize("this.checkAuthorization()")
//    public ResponseEntity<DTO> delete(@PathVariable Integer requestId) {
//        return forExistingRequest(requestId, id
//                -> ResponseEntity.ok(restService().delete(id)));
//    }
//
//    public S getService() {
//        return service;
//    }
//
//    public void setService(S service) {
//        this.service = service;
//    }
    public GenericService<T, Long, D> getService() {
        return service;
    }

    public void setService(GenericService<T, Long, D> service) {
        this.service = service;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

}
