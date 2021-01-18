package com.ticketsystem.bookmymovie.models;

import javax.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private int seat;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Screen screen;

    public Long getId() {
        return this.id;
    }

    public int getSeat() {
        return this.seat;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public Seat() {

    }

    public Seat(int seat, Screen screen) {
        this.seat = seat;
        this.screen = screen;
    }
}
