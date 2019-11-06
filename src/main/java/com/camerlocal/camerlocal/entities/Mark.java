/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author vivien saa
 */
@Entity
public class Mark implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "mark_value")
    private int markValue;

    @ManyToOne
    private User userMarker;

    @ManyToOne
    private Product productMarked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMarkValue() {
        return markValue;
    }

    public void setMarkValue(int markValue) {
        this.markValue = markValue;
    }

    public User getUserMarker() {
        return userMarker;
    }

    public void setUserMarker(User userMarker) {
        this.userMarker = userMarker;
    }

    public Product getProductMarked() {
        return productMarked;
    }

    public void setProductMarked(Product productMarked) {
        this.productMarked = productMarked;
    }

}
