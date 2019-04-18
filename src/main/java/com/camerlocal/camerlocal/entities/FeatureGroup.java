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
public class FeatureGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_feature_group ")
    private Long idFeatureGroup;

    @Column(name = "feature_group_name")
    private String featureGroupName;

    @ManyToOne
    private Product product;

    @OneToMany(mappedBy = "featureGroup")
    private List<FeatureLine> listFeatureLines;

    public Long getIdFeatureGroup() {
        return idFeatureGroup;
    }

    public void setIdFeatureGroup(Long idFeatureGroup) {
        this.idFeatureGroup = idFeatureGroup;
    }

    public String getFeatureGroupName() {
        return featureGroupName;
    }

    public void setFeatureGroupName(String featureGroupName) {
        this.featureGroupName = featureGroupName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<FeatureLine> getListFeatureLines() {
        return listFeatureLines;
    }

    public void setListFeatureLines(List<FeatureLine> listFeatureLines) {
        this.listFeatureLines = listFeatureLines;
    }

}
