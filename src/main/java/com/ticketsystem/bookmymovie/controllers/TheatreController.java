/*
Controller for Theatre-related functions. 
This file defines the API endpoints mapping for Theatre-related functions
*/
package com.ticketsystem.bookmymovie.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.ticketsystem.bookmymovie.dto.theatreDTO.*;
import com.ticketsystem.bookmymovie.services.TheatreService;

@RestController
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping("theatres/")
    public ResponseEntity<Object> getTheatres(TheatreGetDTO theatreGetDTO) {
        return theatreService.getTheatres(theatreGetDTO);
    }

    @PostMapping("theatres/")
    public ResponseEntity<Object> addTheatre(@RequestBody TheatrePostDTO theatreDTO) {
        return theatreService.addTheatre(theatreDTO);
    }
}
