/*
Controller for Movie-related functions. 
This file defines the API endpoints mapping for Movie-related functions
*/
package com.ticketsystem.bookmymovie.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ticketsystem.bookmymovie.dto.cityDTO.CityGetDTO;
import com.ticketsystem.bookmymovie.dto.movieDTO.MovieGetDTO;
import com.ticketsystem.bookmymovie.dto.movieDTO.MoviePostDTO;
import com.ticketsystem.bookmymovie.services.MovieService;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("movies/")
    public ResponseEntity<Object> getMovies(MovieGetDTO movieGetDTO) {
        return movieService.getMovies(movieGetDTO);
    }

    @PostMapping("movies/")
    public ResponseEntity<Object> addMovie(@RequestBody MoviePostDTO movieDTO) {
        return movieService.addMovie(movieDTO);
    }

    @GetMapping("movies/city/")
    public ResponseEntity<Object> getMoviesByCity(CityGetDTO cityGetDTO) {
        return movieService.getMoviesByCity(cityGetDTO);
    }

}
