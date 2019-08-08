/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.controller.GenericRestController;
import com.camerlocal.camerlocal.entities.BaseObject;
import java.lang.reflect.ParameterizedType;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 *
 * @author vivien saa
 * @param <T>
 */
public abstract class GenericResource<T extends BaseObject> extends ResourceSupport {

    protected T entity;

    public abstract GenericResource<T> getInstance(T t);

    public GenericResource() {
    }

    public GenericResource(T t) {
        final long id = t.getId();
        this.entity = t;
//        add(linkTo(methodOn(GenericRestController.class).findById()).withSelfRel(id));
//        add(linkTo(methodOn(GenericRestController.class).findAll()).withRel("full_list"));
//        add(linkTo(methodOn(GenericRestController.class).update(entityClass)).withRel("update"));

    }

    public T getT() {
        return entity;
    }

}
