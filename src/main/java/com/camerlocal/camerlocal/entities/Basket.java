/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author vivien saa
 */
@Entity
public class Basket extends BaseObject {

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "orderDate")
    private Date order_date;

    @ManyToOne
    private User basketOwner;

    @OneToMany(mappedBy = "basketContainer", fetch = FetchType.LAZY)
    private List<ProductState> listProductStates;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public User getBasketOwner() {
        return basketOwner;
    }

    public void setBasketOwner(User basketOwner) {
        this.basketOwner = basketOwner;
    }

    public List<ProductState> getListProductStates() {
        return listProductStates;
    }

    public void setListProductStates(List<ProductState> listProductStates) {
        this.listProductStates = listProductStates;
    }

}
