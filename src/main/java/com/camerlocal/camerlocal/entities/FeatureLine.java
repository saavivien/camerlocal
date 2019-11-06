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
public class FeatureLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "feature_content")
    private String featureContent;

    @ManyToOne
    private FeatureGroup featureGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureContent() {
        return featureContent;
    }

    public void setFeatureContent(String featureContent) {
        this.featureContent = featureContent;
    }

    public FeatureGroup getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(FeatureGroup featureGroup) {
        this.featureGroup = featureGroup;
    }

}
