/*
This File defines the DTO for GET Request of Movie.
*/
package com.ticketsystem.bookmymovie.dto.movieDTO;

public class MovieGetDTO {
    private Long movieId;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
