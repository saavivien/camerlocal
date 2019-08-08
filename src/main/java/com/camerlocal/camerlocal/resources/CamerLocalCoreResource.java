/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.resources;

import com.camerlocal.camerlocal.entities.CoreObject;

/**
 *
 * @author vivien saa
 * @param <CO>
 */
public abstract class CamerLocalCoreResource<CO extends CoreObject> extends GenericResource<CO> {

    public CamerLocalCoreResource() {
        super();
    }

    public CamerLocalCoreResource(CO co) {
        super(co);
    }
}
