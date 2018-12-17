package com.company.carservice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s|description")
@Table(name = "CARSERVICE_REPAIR")
@Entity(name = "carservice_Repair")
public class Repair extends StandardEntity {
    @Column(name = "DESCRIPTION")
    protected String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CENTER_ID")
    protected CarServiceCenter center;

    @JoinTable(name = "CARSERVICE_REPAIR_EMPLOYEE_LINK",
            joinColumns = @JoinColumn(name = "REPAIR_ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @ManyToMany
    protected List<Employee> employee;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public CarServiceCenter getCenter() {
        return center;
    }

    public void setCenter(CarServiceCenter center) {
        this.center = center;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}