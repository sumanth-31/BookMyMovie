/*
This File defines the Repository for Owner which allows us to access the database using ORM.
 */
package com.ticketsystem.bookmymovie.repositories;

import com.ticketsystem.bookmymovie.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    public Optional<Owner> findByMail(String mail);
}
