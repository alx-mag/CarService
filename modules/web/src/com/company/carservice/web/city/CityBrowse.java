package com.company.carservice.web.city;

import com.company.carservice.entity.City;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.util.UUID;

public class CityBrowse extends AbstractLookup
{
    @Inject
    private CityService cityService;

    @Inject
    private GroupDatasource<City, UUID> citiesDs;

    @Inject
    private DataManager dataManager;

    public void markAsDefault(Component source) {
        City selectedCity = citiesDs.getItem();
        if (selectedCity == null) {
            showNotification("Select a city");
            return;
        }

        cityService.resetDefaultCity();
        selectedCity.setDefaultCity(true);
        dataManager.commit(selectedCity);
        citiesDs.refresh();
    }
}