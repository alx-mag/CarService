package com.company.carservice.web.carservicecenter;

import com.company.carservice.entity.City;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.carservice.entity.CarServiceCenter;

import javax.inject.Inject;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    private CityService cityService;

    @Override
    protected void initNewItem(CarServiceCenter item) {
        City defaultCity = cityService.getDefaultCity();
        item.setCity(defaultCity);
    }
}