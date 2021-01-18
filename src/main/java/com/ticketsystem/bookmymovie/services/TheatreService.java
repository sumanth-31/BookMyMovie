package com.ticketsystem.bookmymovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ticketsystem.bookmymovie.models.*;

import java.util.*;

import com.ticketsystem.bookmymovie.dto.theatreDTO.*;
import com.ticketsystem.bookmymovie.repositories.*;
import com.ticketsystem.bookmymovie.utils.Utils;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CityRepository cityRepository;

    public ResponseEntity<Object> addTheatre(TheatrePostDTO theatreDTO) {
        String name = theatreDTO.getName();
        Long ownerId = theatreDTO.getOwnerId();
        Long cityId = theatreDTO.getCityId();
        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
        Optional<Theatre> optionalTheatre = theatreRepository.findByName(name);
        Optional<City> optionalCity = cityRepository.findById(cityId);
        if (optionalOwner.isEmpty()) {
            return Utils.badRequest("Owner doesn't exist");
        }
        if (optionalCity.isEmpty()) {
            return Utils.badRequest("City doesn't exist");
        }
        if (optionalTheatre.isPresent()) {
            return Utils.badRequest("Theatre already exists");
        }
        Owner owner = optionalOwner.get();
        City city = optionalCity.get();
        Theatre theatre = new Theatre(name, city, owner);
        theatreRepository.save(theatre);
        return Utils.okResponse("theatre", theatre);
    }

    public List<Theatre> getTheatresInCity(City city) {
        return theatreRepository.findByCity(city);
    }

    public ResponseEntity<Object> getTheatres(TheatreGetDTO theatreGetDTO) {
        Long theatreId = theatreGetDTO.getTheatreId();
        if (theatreId == null) {
            return Utils.okResponse("theatres", theatreRepository.findAll());
        }
        Optional<Theatre> optionalTheatre = theatreRepository.findById(theatreId);
        if (optionalTheatre.isEmpty()) {
            return Utils.badRequest("Theatre doesn't exist");
        }
        return Utils.okResponse("theatre", optionalTheatre.get());
    }
}
