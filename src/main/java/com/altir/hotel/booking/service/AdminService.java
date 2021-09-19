package com.altir.hotel.booking.service;

import com.altir.hotel.booking.model.Room;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Service
public interface AdminService {

    public Room addRoom(Room room);
    public Room getRoomById(Long roomId);
    public void removeRoom(Long roomId);
    public Room updateRoom(Long roomId,Room room);
    public Room changeRoomPrice(Long roomId,Long roomPrice);
    public Long fetchTotalRevenue();
}
