/*
This File defines the Repository for Seat which allows us to access the database using ORM.
 */
package com.ticketsystem.bookmymovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketsystem.bookmymovie.models.*;
import java.util.*;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    public Optional<Seat> findByScreenAndSeat(Screen screen, int seat);

    public List<Seat> findByScreen(Screen screen);
}
