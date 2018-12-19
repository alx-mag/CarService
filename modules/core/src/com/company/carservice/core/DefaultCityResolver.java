package com.company.carservice.core;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Component("carservice_DefaultCityResolver")
public class DefaultCityResolver {

    public static final String GET_DEFAULT_CITY_QUERY =
            "select c " +
                    "from carservice_City c " +
                    "where c.defaultCity = TRUE";

    @Inject
    private Persistence persistence;

    @Transactional
    public City getDefaultCity() {
        return (City) persistence.getEntityManager().createQuery(GET_DEFAULT_CITY_QUERY).getFirstResult();
    }

    @Transactional
    public void resetDefaultCity() {
        List resultList = persistence.getEntityManager().createQuery(GET_DEFAULT_CITY_QUERY).getResultList();
        resultList.forEach(result -> ((City) result).setDefaultCity(false));
    }
}
