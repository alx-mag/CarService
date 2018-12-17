package com.company.carservice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@NamePattern("%s|name")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "CARSERVICE_CUSTOMER")
@Entity(name = "carservice_Customer")
public class Customer extends StandardEntity {
    @Length(min = 1, max = 100)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")
    @Length(min = 5, max = 50)
    @NotNull
    @Column(name = "EMAIL", nullable = false, unique = true, length = 50)
    protected String email;

    @NotNull
    @Column(name = "PHONE", nullable = false, unique = true)
    protected String phone;

    @JoinTable(name = "CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"))
    @ManyToMany(mappedBy = "")
    protected List<CarServiceCenter> carServiceCenters;

    public List<CarServiceCenter> getCarServiceCenters() {
        return carServiceCenters;
    }

    public void setCarServiceCenters(List<CarServiceCenter> carServiceCenters) {
        this.carServiceCenters = carServiceCenters;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}