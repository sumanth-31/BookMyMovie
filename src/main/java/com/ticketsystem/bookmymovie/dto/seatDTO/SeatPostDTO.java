package com.ticketsystem.bookmymovie.dto.seatDTO;

public class SeatPostDTO {
    private Long screenId;
    private int seats[];

    public Long getScreenId() {
        return screenId;
    }

    public int[] getSeats() {
        return seats;
    }
}
