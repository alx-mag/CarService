package com.company.carservice.web.city;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.AbstractEditor;

import javax.inject.Inject;

public class CityEdit extends AbstractEditor<City>
{
    @Inject
    private DataManager dataManager;

    // Controller side implementation of default city reset
    @Override
    protected boolean preCommit() {
        City currentCity = getItem();
        if (currentCity.getDefaultCity()) {
            dataManager.loadList(LoadContext.create(City.class))
                    .stream().filter(city -> city.getDefaultCity() && city != currentCity).forEach(city -> {
                        city.setDefaultCity(false);
                        dataManager.commit(city);
            });
        }
        return true;
    }
}