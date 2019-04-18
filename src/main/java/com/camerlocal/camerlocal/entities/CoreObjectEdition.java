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
public class CoreObjectEdition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_core_cbject_edition")
    private Long idCoreObjectEdition;

    @ManyToOne
    private User usereditor;

    @ManyToOne
    private CoreObject coreObjectEdited;

    public Long getIdCoreObjectEdition() {
        return idCoreObjectEdition;
    }

    public void setIdCoreObjectEdition(Long idCoreObjectEdition) {
        this.idCoreObjectEdition = idCoreObjectEdition;
    }

    public User getUsereditor() {
        return usereditor;
    }

    public void setUsereditor(User usereditor) {
        this.usereditor = usereditor;
    }

    public CoreObject getCoreObjectEdited() {
        return coreObjectEdited;
    }

    public void setCoreObjectEdited(CoreObject coreObjectEdited) {
        this.coreObjectEdited = coreObjectEdited;
    }

}
