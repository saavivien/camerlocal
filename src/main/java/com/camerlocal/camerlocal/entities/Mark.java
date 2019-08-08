/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author vivien saa
 */
@Entity
public class Mark extends BaseObject {

    @Column(name = "mark_value")
    private int markValue;

    @ManyToOne
    private User userMarker;

    @ManyToOne
    private Product productMarked;

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
