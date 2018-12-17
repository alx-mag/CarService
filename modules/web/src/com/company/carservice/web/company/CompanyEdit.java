package com.company.carservice.web.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Company;


@UiController("carservice_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
}