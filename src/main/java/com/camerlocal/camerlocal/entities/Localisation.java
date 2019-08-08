/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author vivien saa
 */
@Entity
public class Localisation extends BaseObject {

    private String city;

    @OneToMany(mappedBy = "localisation", fetch = FetchType.LAZY)
    private List<Periods> listPeriods;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Periods> getListPeriods() {
        return listPeriods;
    }

    public void setListPeriods(List<Periods> listPeriods) {
        this.listPeriods = listPeriods;
    }

}
