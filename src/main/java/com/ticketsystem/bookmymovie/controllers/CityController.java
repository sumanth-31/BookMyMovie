package com.ticketsystem.bookmymovie.controllers;

import com.ticketsystem.bookmymovie.dto.cityDTO.CityGetDTO;
import com.ticketsystem.bookmymovie.dto.cityDTO.CityPostDTO;
import com.ticketsystem.bookmymovie.services.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("cities/")
    public ResponseEntity<Object> addCity(@RequestBody CityPostDTO cityPostDTO) {
        return cityService.addCity(cityPostDTO);
    }

    @GetMapping("cities/")
    public ResponseEntity<Object> getCities(CityGetDTO cityGetDTO) {
        return cityService.getCities(cityGetDTO);
    }
}
