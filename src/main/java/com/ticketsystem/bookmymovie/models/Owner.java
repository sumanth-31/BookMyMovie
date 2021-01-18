package com.ticketsystem.bookmymovie.models;

import javax.persistence.*;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String mail;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public Owner() {

    }

    public Owner(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }
}
