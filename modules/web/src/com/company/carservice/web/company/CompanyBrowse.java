package com.company.carservice.web.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Company;


@UiController("carservice_Company.browse")
@UiDescriptor("company-browse.xml")
@LookupComponent("companiesTable")
@LoadDataBeforeShow
public class CompanyBrowse extends StandardLookup<Company> {
}