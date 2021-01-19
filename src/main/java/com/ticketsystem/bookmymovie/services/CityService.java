/*
This File defines the Service for City that contains the business logic for various functions.
 */
package com.ticketsystem.bookmymovie.services;

import com.ticketsystem.bookmymovie.dto.cityDTO.*;
import com.ticketsystem.bookmymovie.models.*;
import com.ticketsystem.bookmymovie.repositories.CityRepository;
import com.ticketsystem.bookmymovie.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public ResponseEntity<Object> addCity(CityPostDTO cityPostDTO) {
        String name = cityPostDTO.getName();
        Optional<City> optionalCity = cityRepository.findByName(name);
        if (optionalCity.isPresent()) {
            return Utils.badRequest("City already exists!");
        }
        City city = new City(name);
        cityRepository.save(city);
        return Utils.okResponse("city", city);
    }

    public ResponseEntity<Object> getCities(CityGetDTO cityGetDTO) {
        Long cityId = cityGetDTO.getCityId();
        if (cityId == null)
            return Utils.okResponse("cities", cityRepository.findAll());
        Optional<City> city = cityRepository.findById(cityId);
        if (city.isEmpty()) {
            return Utils.badRequest("City doens't exist");
        }
        return Utils.okResponse("city", city.get());
    }

}
