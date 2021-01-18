package com.ticketsystem.bookmymovie.controllers;

import com.ticketsystem.bookmymovie.dto.screenDTO.AddScreenDTO;
import com.ticketsystem.bookmymovie.dto.screenDTO.GetScreenDTO;
import com.ticketsystem.bookmymovie.services.ScreenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScreenController {
    @Autowired
    private ScreenService screenService;

    @PostMapping("screens/")
    public ResponseEntity<Object> addScreen(@RequestBody AddScreenDTO addScreenDTO) {
        return screenService.addScreen(addScreenDTO);
    }

    @GetMapping("screens/")
    public ResponseEntity<Object> getScreens(GetScreenDTO getScreenDTO) {
        return screenService.getScreens(getScreenDTO);
    }
}
