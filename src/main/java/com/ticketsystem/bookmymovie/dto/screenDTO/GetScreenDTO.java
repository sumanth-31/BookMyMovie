package com.ticketsystem.bookmymovie.dto.screenDTO;

public class GetScreenDTO {
    private Long theatreId;

    public GetScreenDTO() {

    }

    public GetScreenDTO(Long theatreId) {
        this.theatreId = theatreId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }
}
