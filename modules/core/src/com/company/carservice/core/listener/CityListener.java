package com.company.carservice.core.listener;

import com.company.carservice.core.DefaultCityResolver;
import com.company.carservice.entity.City;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.PersistenceTools;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("carservice_CityListener")
public class CityListener implements BeforeInsertEntityListener<City>, BeforeUpdateEntityListener<City>
{
    @Inject
    private DefaultCityResolver defaultCityResolver;

//    @Inject
//    private PersistenceTools persistenceTools;

    @Override
    public void onBeforeInsert(City entity, EntityManager entityManager) {
        if (entity.getDefaultCity()) {
            defaultCityResolver.resetDefaultCity();
        }
    }

    @Override
    public void onBeforeUpdate(City entity, EntityManager entityManager) {
        if (entity.getDefaultCity()) {
            defaultCityResolver.resetDefaultCity();
        }
    }
}
