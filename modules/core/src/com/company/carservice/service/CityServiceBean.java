package com.company.carservice.service;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    public static final String GET_DEFAULT_CITY_QUERY =
            "select c " +
            "from carservice_City c " +
            "where c.defaultCity = TRUE";

    @Inject
    private DataManager dataManager;

    @Override
    public City getDefaultCity() {
        return dataManager.loadValue(GET_DEFAULT_CITY_QUERY, City.class).one();
    }
}