/*
This File defines the Model(Table) for Screen Entity
 */
package com.ticketsystem.bookmymovie.models;

import javax.persistence.*;

@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Theatre theatre;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Movie movie;
    private int numberOfSeats;

    public Screen() {
    }

    public Screen(Theatre theatre, Movie movie, int numberOfSeats) {
        this.theatre = theatre;
        this.movie = movie;
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Movie getMovie() {
        return movie;
    }

}
