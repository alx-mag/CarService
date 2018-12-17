package com.company.carservice.service;

import com.company.carservice.entity.City;

public interface CityService {
    String NAME = "carservice_CityService";

    City getDefaultCity();
}