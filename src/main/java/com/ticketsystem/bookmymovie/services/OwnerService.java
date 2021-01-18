package com.ticketsystem.bookmymovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ticketsystem.bookmymovie.repositories.OwnerRepository;
import com.ticketsystem.bookmymovie.dto.ownerDTO.*;
import com.ticketsystem.bookmymovie.models.Owner;
import com.ticketsystem.bookmymovie.utils.Utils;
import java.util.*;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public ResponseEntity<Object> addOwner(OwnerPostDTO ownerDTO) {
        String name = ownerDTO.getName();
        String mail = ownerDTO.getMail();
        Optional<Owner> optionalOwner = ownerRepository.findByMail(mail);
        if (optionalOwner.isPresent()) {
            return Utils.badRequest("Owner already exists!");
        }
        Owner owner = new Owner(name, mail);
        ownerRepository.save(owner);
        return Utils.okResponse("owner", owner);
    }

    public ResponseEntity<Object> getOwners(OwnerGetDTO ownerGetDTO) {
        Long ownerId = ownerGetDTO.getOwnerId();
        if (ownerId == null) {
            return Utils.okResponse("owners", ownerRepository.findAll());
        }
        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
        if (optionalOwner.isEmpty()) {
            return Utils.badRequest("Owner doesn't exist");
        }

        return Utils.okResponse("owner", optionalOwner.get());
    }
}
