/*
This File defines the DTO for POST Request of Theatre.
*/
package com.ticketsystem.bookmymovie.dto.theatreDTO;

public class TheatrePostDTO {
    private String name;
    private Long cityId;
    private Long ownerId;

    TheatrePostDTO() {
    }

    public String getName() {
        return name;
    }

    public Long getCityId() {
        return cityId;
    }

    public Long getOwnerId() {
        return ownerId;
    }
}
