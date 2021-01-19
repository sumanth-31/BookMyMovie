/*
This File defines the DTO for GET Request of Owner.
*/
package com.ticketsystem.bookmymovie.dto.ownerDTO;

public class OwnerGetDTO {
    private Long ownerId;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
