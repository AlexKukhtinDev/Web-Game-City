package com.akukhtin.webgamecity.service;

import com.akukhtin.webgamecity.model.City;

public interface CityService {
    City findRandomCityById();

    String findCityByCity(String newWord);
}
