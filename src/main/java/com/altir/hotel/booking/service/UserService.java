package com.altir.hotel.booking.service;

import com.altir.hotel.booking.model.Booking;
import com.altir.hotel.booking.model.BookingForm;
import com.altir.hotel.booking.model.Room;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface UserService {

   public Booking bookRoom(BookingForm bookingForm);
   public List<Room> getRooms();
   public List<Room> getAllVailableRooms(Date date);
   public List<Room> getAllBookedRooms(Date date);
   public Long fetchRoomPricesOfUser(Long userId);
}
