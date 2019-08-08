/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author vivien saa
 */
@Entity
public class CoreObjectEdition extends BaseObject {

    @ManyToOne
    private User usereditor;

    @ManyToOne
    private CoreObject coreObjectEdited;

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
