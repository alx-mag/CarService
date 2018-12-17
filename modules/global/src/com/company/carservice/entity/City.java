package com.company.carservice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "CARSERVICE_CITY")
@Entity(name = "carservice_City")
public class City extends StandardEntity {
    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    protected String name;

    @NotNull
    @Column(name = "CODE", nullable = false, unique = true)
    protected String code;

    @Column(name = "DEFAULT_CITY", nullable = false)
    protected Boolean defaultCity = false;

    public Boolean getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(Boolean defaultCity) {
        this.defaultCity = defaultCity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}