/*
This File defines the Repository for City which allows us to access the database using ORM.
 */
package com.ticketsystem.bookmymovie.repositories;

import com.ticketsystem.bookmymovie.models.City;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    public Optional<City> findByName(String name);
}
