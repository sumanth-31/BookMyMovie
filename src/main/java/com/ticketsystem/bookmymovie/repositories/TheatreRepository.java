package com.ticketsystem.bookmymovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketsystem.bookmymovie.models.*;
import java.util.*;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    public Optional<Theatre> findByName(String name);

    public List<Theatre> findByCity(City city);
}
