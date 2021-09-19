package com.altir.hotel.booking.model;

import java.util.Date;
import java.util.List;

public class RoomDates {

    private Long roomId;
    private List<Date> datesList;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public List<Date> getDatesList() {
        return datesList;
    }

    public void setDatesList(List<Date> datesList) {
        this.datesList = datesList;
    }
}
