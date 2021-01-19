package com.ticketsystem.bookmymovie.repositories;

import java.util.Optional;

import com.ticketsystem.bookmymovie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Optional<Movie> findByName(String name);
}
