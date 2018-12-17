package com.company.carservice.web.city;

import com.company.carservice.entity.City;
import com.haulmont.cuba.gui.screen.*;


@UiController("carservice_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {

    

}