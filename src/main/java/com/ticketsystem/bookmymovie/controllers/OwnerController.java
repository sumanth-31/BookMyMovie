package com.ticketsystem.bookmymovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ticketsystem.bookmymovie.services.OwnerService;
import com.ticketsystem.bookmymovie.dto.ownerDTO.*;

@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("owners/")
    public ResponseEntity<Object> addOwner(@RequestBody OwnerPostDTO ownerDTO) {
        return ownerService.addOwner(ownerDTO);
    }

    @GetMapping("owners/")
    public ResponseEntity<Object> getOwners(OwnerGetDTO ownerGetDTO) {
        return ownerService.getOwners(ownerGetDTO);
    }
}
