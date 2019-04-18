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
public class AbundancePeriod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_abundance_period")
    private Long idAbundancePeriod;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    private Periods periods;

    public Long getIdAbundancePeriod() {
        return idAbundancePeriod;
    }

    public void setIdAbundancePeriod(Long idAbundancePeriod) {
        this.idAbundancePeriod = idAbundancePeriod;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Periods getPeriods() {
        return periods;
    }

    public void setPeriods(Periods periods) {
        this.periods = periods;
    }

}
