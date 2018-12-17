package com.company.carservice.web.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Employee;


@UiController("carservice_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
}