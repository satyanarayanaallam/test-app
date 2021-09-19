package com.altir.hotel.booking.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ROOM")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROOM_ID")
    private Long roomId;

    @Column(name="ROOM_TYPE")
    private String roomType;

    @Column(name="FLOOR")
    private int floor;

    @Column(name="ROOM_NO")
    private String roomNo;

    @Column(name="ROOM_RENT")
    private long roomRent;

    @Column(name="ROOM_AVAILABILITY")
    private Boolean roomAvailability;

    @ManyToOne(fetch=FetchType.LAZY)
    private Booking booking;

    @OneToMany(mappedBy="room")
    private List<Dates> datesList;

    public Room(String roomType, int floor, String roomNo, long roomRent, Boolean roomAvailability) {
        this.roomType = roomType;
        this.floor = floor;
        this.roomNo = roomNo;
        this.roomRent = roomRent;
        this.roomAvailability = roomAvailability;
    }

    public Room() {

    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public long getRoomRent() {
        return roomRent;
    }

    public void setRoomRent(long roomRent) {
        this.roomRent = roomRent;
    }

    public Boolean getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(Boolean roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
