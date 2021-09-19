package com.altir.hotel.booking.model;

import java.util.List;

public class BookingForm {

    private User user;
    private List<RoomDates> roomDates;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RoomDates> getRoomDates() {
        return roomDates;
    }

    public void setRoomDates(List<RoomDates> roomDates) {
        this.roomDates = roomDates;
    }
}
