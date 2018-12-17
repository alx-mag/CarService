package com.company.carservice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NamePattern("%s %s|firstName,lastName")
@Table(name = "CARSERVICE_EMPLOYEE")
@Entity(name = "carservice_Employee")
public class Employee extends StandardEntity {
    @NotNull
    @Column(name = "FIRST_NAME", nullable = false, unique = true)
    protected String firstName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false, unique = true)
    protected String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    protected Date birthDate;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "SALARY")
    protected String salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CENTER_ID")
    protected CarServiceCenter center;

    @JoinTable(name = "CARSERVICE_REPAIR_EMPLOYEE_LINK",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "REPAIR_ID"))
    @ManyToMany
    protected List<Repair> repairs;

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public CarServiceCenter getCenter() {
        return center;
    }

    public void setCenter(CarServiceCenter center) {
        this.center = center;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}