package com.company.carservice.web.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Employee;


@UiController("carservice_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
}