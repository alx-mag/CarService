package com.company.carservice.service;

import com.company.carservice.core.DefaultCityResolver;
import com.company.carservice.entity.City;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service(CityService.NAME)
public class CityServiceBean implements CityService
{
    @Inject
    private DefaultCityResolver defaultCityResolver;

    @Override
    public City getDefaultCity() {
        return defaultCityResolver.getDefaultCity();
    }

    @Override
    public void resetDefaultCity() {
        defaultCityResolver.resetDefaultCity();
    }
}