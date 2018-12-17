package com.company.carservice.service;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    public static final String GET_DEFAULT_CITY_QUERY =
            "select c " +
            "from carservice_City c " +
            "where c.defaultCity = TRUE";

    @Inject
    private DataManager dataManager;

    @Inject
    private Persistence persistence;

    @Override
    @Transactional
    public City getDefaultCity() {
        return (City) persistence.getEntityManager().createQuery(GET_DEFAULT_CITY_QUERY).getFirstResult();
    }

    @Override
    @Transactional
    public void resetDefaultCity() {
        List resultList = persistence.getEntityManager().createQuery(GET_DEFAULT_CITY_QUERY).getResultList();
        resultList.forEach(result -> ((City) result).setDefaultCity(false));
    }
}