package com.ticketsystem.bookmymovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticketsystem.bookmymovie.dto.seatDTO.*;
import com.ticketsystem.bookmymovie.services.SeatService;

@RestController
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping("seats/")
    public ResponseEntity<Object> bookSeat(@RequestBody SeatPostDTO seatPostDTO) {
        return seatService.bookSeats(seatPostDTO);
    }

    @GetMapping("seats/")
    public ResponseEntity<Object> getBookedSeats(SeatGetDTO seatGetDTO) {
        return seatService.getBookedSeats(seatGetDTO);
    }
}
