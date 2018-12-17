package com.company.carservice.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "CARSERVICE_COMPANY")
@Entity(name = "carservice_Company")
public class Company extends Customer {
    @Length(min = 12, max = 12)
    @NotNull
    @Column(name = "INN", nullable = false, unique = true, length = 12)
    protected String inn;

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}