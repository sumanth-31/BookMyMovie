package com.ticketsystem.bookmymovie.services;

import java.util.List;
import java.util.Optional;

import com.ticketsystem.bookmymovie.dto.movieDTO.*;
import com.ticketsystem.bookmymovie.dto.cityDTO.CityGetDTO;
import com.ticketsystem.bookmymovie.models.*;
import com.ticketsystem.bookmymovie.repositories.CityRepository;
import com.ticketsystem.bookmymovie.repositories.MovieRepository;
import com.ticketsystem.bookmymovie.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private ScreenService screenService;

    public ResponseEntity<Object> addMovie(MoviePostDTO movieDTO) {
        String name = movieDTO.getName();
        Optional<Movie> optionalMovie = movieRepository.findByName(name);
        if (optionalMovie.isPresent()) {
            return Utils.badRequest("Movie already exists!");
        }
        Movie movie = new Movie(name);
        movieRepository.save(movie);
        return Utils.okResponse("movie", movie);
    }

    public ResponseEntity<Object> getMovies(MovieGetDTO movieGetDTO) {
        Long movieId = movieGetDTO.getMovieId();
        if (movieId == null) {
            List<Movie> movies = movieRepository.findAll();
            return Utils.okResponse("movies", movies);
        }
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            return Utils.badRequest("Movie doesn't exist");
        }
        return Utils.okResponse("movie", optionalMovie.get());
    }

    public ResponseEntity<Object> getMoviesByCity(CityGetDTO cityGetDTO) {
        Long cityId = cityGetDTO.getCityId();
        Optional<City> optionalCity = cityRepository.findById(cityId);
        if (optionalCity.isEmpty()) {
            return Utils.badRequest("City doesn't exist");
        }
        City city = optionalCity.get();
        List<Theatre> theatres = theatreService.getTheatresInCity(city);
        List<Screen> screens = new ArrayList<>();
        for (Theatre theatre : theatres) {
            screens.addAll(screenService.getScreensByTheatre(theatre));
        }
        Set<Movie> movies = new LinkedHashSet<>();
        for (Screen screen : screens) {
            movies.add(screen.getMovie());
        }
        return Utils.okResponse("movies", movies);
    }
}
