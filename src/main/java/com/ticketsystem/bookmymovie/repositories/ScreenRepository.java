/*
This File defines the Repository for Screen which allows us to access the database using ORM.
 */
package com.ticketsystem.bookmymovie.repositories;

import com.ticketsystem.bookmymovie.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    public Optional<Screen> findByTheatreAndMovie(Theatre theatre, Movie movie);

    public List<Screen> findByTheatre(Theatre theatre);
}
