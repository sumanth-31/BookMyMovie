package com.ticketsystem.bookmymovie.dto.screenDTO;

public class GetScreenDTO {
    private Long theatreId;
    private Long screenId;

    public GetScreenDTO() {

    }

    public GetScreenDTO(Long theatreId, Long screenId) {
        this.theatreId = theatreId;
        this.screenId = screenId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }
}
