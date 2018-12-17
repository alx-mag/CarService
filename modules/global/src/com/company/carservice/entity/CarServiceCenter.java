package com.company.carservice.entity;

import com.company.carservice.service.CityService;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "CARSERVICE_CAR_SERVICE_CENTER")
@Entity(name = "carservice_CarServiceCenter")
public class CarServiceCenter extends StandardEntity {
    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "PHONE", nullable = false)
    protected String phone;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "center")
    protected List<Employee> employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @JoinTable(name = "CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK",
            joinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    @ManyToMany(mappedBy = "")
    protected List<Customer> customer;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "center")
    protected List<Repair> repair;

    public List<Repair> getRepair() {
        return repair;
    }

    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}