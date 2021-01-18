package com.ticketsystem.bookmymovie.models;

import javax.persistence.*;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private City city;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Owner owner;

    public Theatre() {

    }

    public Theatre(String name, City city, Owner owner) {
        this.name = name;
        this.city = city;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public City getCity() {
        return city;
    }

    public String toString() {
        return "id = " + id + " name = " + name + " city = " + city + " owner = " + owner;
    }

}