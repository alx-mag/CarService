package com.company.carservice.web.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Customer;


@UiController("carservice_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}