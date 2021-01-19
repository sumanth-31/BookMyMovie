/*
This File defines the DTO for Adding screen.
*/
package com.ticketsystem.bookmymovie.dto.screenDTO;

import com.ticketsystem.bookmymovie.utils.Constants;

public class AddScreenDTO {
    private Long movieId, theatreId;
    private Integer numberOfSeats;

    public AddScreenDTO() {
        this.numberOfSeats = Constants.defaultNumberOfSeats;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

}
