package com.company.carservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "CARSERVICE_INDIVIDUAL")
@Entity(name = "carservice_Individual")
public class Individual extends Customer {
    @NotNull
    @Column(name = "PASSPORT_NO", nullable = false, unique = true)
    protected String passportNo;

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
}