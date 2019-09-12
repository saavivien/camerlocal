/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author vivien saa
 */
@Entity
public class ProductState implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "aquirement_date")
    private Date aquirementDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "sending_date")
    private Date sendingDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "delivery_date")
    private Date deliveryDate;

    @ManyToOne
    private Basket basketContainer;

    @ManyToOne
    private Product productContainted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAquirementDate() {
        return aquirementDate;
    }

    public void setAquirementDate(Date aquirementDate) {
        this.aquirementDate = aquirementDate;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Basket getBasketContainer() {
        return basketContainer;
    }

    public void setBasketContainer(Basket basketContainer) {
        this.basketContainer = basketContainer;
    }

    public Product getProductContainted() {
        return productContainted;
    }

    public void setProductContainted(Product productContainted) {
        this.productContainted = productContainted;
    }

}
