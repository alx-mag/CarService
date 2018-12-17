package com.company.carservice.web.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Customer;


@UiController("carservice_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}