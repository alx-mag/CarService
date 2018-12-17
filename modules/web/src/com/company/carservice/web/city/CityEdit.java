package com.company.carservice.web.city;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.City;


@UiController("carservice_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {
}