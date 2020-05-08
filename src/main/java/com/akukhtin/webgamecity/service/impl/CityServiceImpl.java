package com.akukhtin.webgamecity.service.impl;

import com.akukhtin.webgamecity.model.City;
import com.akukhtin.webgamecity.repository.CityRepository;
import com.akukhtin.webgamecity.service.CityService;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Transactional
    @Override
    public City findRandomCityById() {
        long value = putOutRandomId();
        cityRepository.setUsageWord(value);
        return cityRepository.getOne(value);
    }

    @Transactional
    @Override
    public String findCityByCity(String newWord) {
        City city = cityRepository.findByCityName(newWord);
        if (city != null) {
            cityRepository.setUsageWord(city.getId());
        } else {
            City newCity = new City();
            newCity.setUsageWord(true);
            cityRepository.save(newCity);
        }

        return cityRepository.findByLetter(newWord.charAt(newWord.length() - 1));
    }

    private long putOutRandomId() {
        Random random = new Random();
        return random.nextLong() * cityRepository.countByElement();
    }
}
