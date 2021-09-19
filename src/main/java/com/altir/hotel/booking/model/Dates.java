package com.altir.hotel.booking.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="DATES")
public class Dates {

    @Id
    @GeneratedValue
    private Long dateId;

   @Column(name="ROOM_DATE")
    private Date roomDate;

    @ManyToOne(fetch=FetchType.LAZY)
    private Room room;

    @ManyToOne(fetch=FetchType.LAZY)
    private Booking booking;

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    public Date getRoomDate() {
        return roomDate;
    }

    public void setRoomDate(Date roomDate) {
        this.roomDate = roomDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
