/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.controller.CategoryController;
import com.camerlocal.camerlocal.entities.Category;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 *
 * @author vivien saa
 */
public class CategoryResource extends ResourceSupport {

    private final Category category;

    public CategoryResource(final Category category) throws Exception {
        this.category = category;
        final long id = category.getId();
        add(linkTo(methodOn(CategoryController.class).findCategoryById(id)).withSelfRel());
        add(linkTo(methodOn(CategoryController.class).findAllCategory()).withRel("categories"));
        add(linkTo(methodOn(CategoryController.class).updateCategory(category)).withRel("update"));
//        add(linkTo(methodOn(CategoryController.class).deleteCategory(category.getId())).withRel("delete"));
    }

    public Category getCategory() {
        return category;
    }

}
