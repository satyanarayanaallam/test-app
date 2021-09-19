package com.altir.hotel.booking.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOKING_ID")
    private Long bookingId;

    @Column(name="USER_ID")
    private Long userId;

    @OneToMany(mappedBy="booking")
    private List<Room> roomsList;

    @OneToMany(mappedBy="booking")
    private List<Dates> datesList;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Room> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Room> roomsList) {
        this.roomsList = roomsList;
    }

    public List<Dates> getDatesList() {
        return datesList;
    }

    public void setDatesList(List<Dates> datesList) {
        this.datesList = datesList;
    }
}
