/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author vivien saa
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CoreObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    protected String name;

    protected String description;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "creation_date")
    protected Date creationDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "modification_date")
    protected Date modificationDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "archiving_date")
    protected Date archivingDate;

    @Column(name = "is_active")
    protected Boolean isActive;

    @ManyToOne
    @JsonBackReference
    protected User userCreator;

    @ManyToOne(optional = true)
    protected User userArchivist;

    @JsonIgnore
    @OneToMany(mappedBy = "coreObjectEdited", fetch = FetchType.LAZY)
    protected List<CoreObjectEdition> listCoreObjectEditions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Date getArchivingDate() {
        return archivingDate;
    }

    public void setArchivingDate(Date archivingDate) {
        this.archivingDate = archivingDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public User getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }

    public User getUserArchivist() {
        return userArchivist;
    }

    public void setUserArchivist(User userArchivist) {
        this.userArchivist = userArchivist;
    }

    public List<CoreObjectEdition> getListCoreObjectEditions() {
        return listCoreObjectEditions;
    }

    public void setListCoreObjectEditions(List<CoreObjectEdition> listCoreObjectEditions) {
        this.listCoreObjectEditions = listCoreObjectEditions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
