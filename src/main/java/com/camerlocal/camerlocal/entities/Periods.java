/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author vivien saa
 */
@Entity
public class Periods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Localisation localisation;

    @OneToMany(mappedBy = "periods", fetch = FetchType.LAZY)
    private List<AbundancePeriod> listAbundancePeriods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public List<AbundancePeriod> getListAbundancePeriods() {
        return listAbundancePeriods;
    }

    public void setListAbundancePeriods(List<AbundancePeriod> listAbundancePeriods) {
        this.listAbundancePeriods = listAbundancePeriods;
    }

}
