package com.ticketsystem.bookmymovie.services;

import com.ticketsystem.bookmymovie.dto.seatDTO.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ticketsystem.bookmymovie.repositories.*;
import com.ticketsystem.bookmymovie.models.*;
import java.util.*;
import com.ticketsystem.bookmymovie.utils.Utils;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    ScreenRepository screenRepository;

    public ResponseEntity<Object> getBookedSeats(SeatGetDTO seatGetDTO) {
        Long screenId = seatGetDTO.getScreenId();
        Optional<Screen> optionalScreen = screenRepository.findById(screenId);
        if (optionalScreen.isEmpty()) {
            return Utils.badRequest("Screen doesn't exist!");
        }
        Screen screen = optionalScreen.get();
        List<Seat> bookedSeats = seatRepository.findByScreen(screen);
        return Utils.okResponse("seats", bookedSeats);
    }

    public ResponseEntity<Object> bookSeats(SeatPostDTO seatPostDTO) {
        Long screenId = seatPostDTO.getScreenId();
        int seatNumbers[] = seatPostDTO.getSeats();
        Optional<Screen> optionalScreen = screenRepository.findById(screenId);
        if (optionalScreen.isEmpty()) {
            return Utils.badRequest("Screen doesn't exist!");
        }
        Screen screen = optionalScreen.get();
        for (int seatNumber : seatNumbers) {
            boolean seatBooked = seatRepository.findByScreenAndSeat(screen, seatNumber).isPresent();
            if (seatBooked || seatNumber < 1 || seatNumber > screen.getNumberOfSeats()) {
                return Utils.badRequest("One or more seats are booked or the details are invalid");
            }
        }
        List<Seat> bookedSeats = new ArrayList<>();
        for (int seatNumber : seatNumbers) {
            Seat seat = new Seat(seatNumber, screen);
            seatRepository.save(seat);
            bookedSeats.add(seat);
        }
        return Utils.okResponse("seats", bookedSeats);
    }
}
