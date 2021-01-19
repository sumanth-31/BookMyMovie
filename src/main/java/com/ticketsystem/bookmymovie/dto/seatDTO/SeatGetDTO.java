/*
This File defines the DTO for GET Request of Seat(Ticket).
*/
package com.ticketsystem.bookmymovie.dto.seatDTO;

public class SeatGetDTO {
    private Long screenId;

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }
}
