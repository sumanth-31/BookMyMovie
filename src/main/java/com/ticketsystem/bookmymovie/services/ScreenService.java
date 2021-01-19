/*
This File defines the Service for Screen that contains the business logic for various functions.
 */
package com.ticketsystem.bookmymovie.services;

import com.ticketsystem.bookmymovie.dto.screenDTO.*;
import com.ticketsystem.bookmymovie.models.*;
import com.ticketsystem.bookmymovie.repositories.*;
import com.ticketsystem.bookmymovie.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ScreenService {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenRepository screenRepository;

    public ResponseEntity<Object> addScreen(AddScreenDTO addScreenDTO) {
        Long theatreId = addScreenDTO.getTheatreId();
        Long movieId = addScreenDTO.getMovieId();
        int numberOfSeats = addScreenDTO.getNumberOfSeats();
        Optional<Theatre> optionalTheatre = theatreRepository.findById(theatreId);
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (numberOfSeats < 1) {
            return Utils.badRequest("There should be atleast one seat");
        }
        if (optionalMovie.isEmpty()) {
            return Utils.badRequest("Movie doesn't exist");
        }
        if (optionalTheatre.isEmpty()) {
            return Utils.badRequest("Theatre doesn't exist");
        }
        Theatre theatre = optionalTheatre.get();
        Movie movie = optionalMovie.get();
        Optional<Screen> optionalScreen = screenRepository.findByTheatreAndMovie(theatre, movie);
        if (optionalScreen.isPresent()) {
            return Utils.badRequest("Movie already exists in the theatre");
        }
        Screen screen = new Screen(theatre, movie, numberOfSeats);
        screenRepository.save(screen);
        return Utils.okResponse("screen", screen);
    }

    public ResponseEntity<Object> getScreens(GetScreenDTO getScreenDTO) {
        Long theatreId = getScreenDTO.getTheatreId();
        if (theatreId == null) {
            Long screenId = getScreenDTO.getScreenId();
            if (screenId == null)
                return Utils.okResponse("screens", screenRepository.findAll());
            return Utils.okResponse("screen", screenRepository.findById(screenId));
        }
        Optional<Theatre> optionalTheatre = theatreRepository.findById(theatreId);
        if (optionalTheatre.isEmpty()) {
            return Utils.badRequest("Theatre doesn't exist");
        }
        Theatre theatre = optionalTheatre.get();
        return Utils.okResponse("screens", getScreensByTheatre(theatre));
    }

    public List<Screen> getScreensByTheatre(Theatre theatre) {
        return screenRepository.findByTheatre(theatre);
    }
}
