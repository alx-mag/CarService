package com.company.carservice.web.city;

import com.company.carservice.entity.City;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.UUID;

public class CityEdit extends AbstractEditor<City> {

    @Inject
    private CityService cityService;



//
//    @Override
//    protected boolean preCommit() {
//        if (getItem().getDefaultCity()) {
//            cityService.resetDefaultCity();
//        }
//
//        return true;
//    }
}