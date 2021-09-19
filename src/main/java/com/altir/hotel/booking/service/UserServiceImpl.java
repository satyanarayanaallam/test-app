package com.altir.hotel.booking.service;

import com.altir.hotel.booking.exceptions.ResourceNotFoundException;
import com.altir.hotel.booking.model.*;
import com.altir.hotel.booking.repository.BookingRepo;
import com.altir.hotel.booking.repository.DatesRepo;
import com.altir.hotel.booking.repository.RoomRepo;
import com.altir.hotel.booking.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    DatesRepo datesRepo;

    @Override
    public Booking bookRoom(BookingForm bookingForm) {
       User user= bookingForm.getUser();
       List<RoomDates> roomDatesList =bookingForm.getRoomDates();
      for(RoomDates roomDate:roomDatesList){
         if(checkRoomAvailability(roomDate)){
             throw new ResourceNotFoundException("Rooms are not available for this dates");
         }
      }
      User us=userRepo.save(user);
      Booking booking=new Booking();
      booking.setUserId(us.getUserId());
      Booking book=bookingRepo.save(booking);
      for(RoomDates roomDate:roomDatesList){
         List<Date> dates=roomDate.getDatesList();
         Room room=roomRepo.getById(roomDate.getRoomId());
         for(Date date:dates){
             Dates datesData=new Dates();
             datesData.setRoom(room);
             datesData.setRoomDate(date);
             datesData.setBooking(book);
         }
      }
      return book;
    }

    @Override
    public List<Room> getRooms() {
        return roomRepo.findAll();
    }

    @Override
    public List<Room> getAllVailableRooms(Date date) {
        List<Dates> dates=datesRepo.findAllAvailableRooms(date);
        List<Room> roomList=new ArrayList<Room>();
        dates.forEach(obj->{
            roomList.add(obj.getRoom());
        });
        return roomList;
    }

    @Override
    public List<Room> getAllBookedRooms(Date date) {
        List<Dates> dates=datesRepo.findAllOccupiedRooms(date);
        List<Room> roomList=new ArrayList<Room>();
        dates.forEach(obj->{
            roomList.add(obj.getRoom());
        });
        return roomList;
    }

    @Override
    public Long fetchRoomPricesOfUser(Long userId) {
        List<Booking> bookingList=bookingRepo.findByUserId(userId);
        Long amount=0L;
        if(bookingList.size()>0){
            Booking booking= bookingList.get(0);
           List<Room> roomList= booking.getRoomsList();
            for(Room room:roomList){
                amount=amount+room.getRoomRent();
            }
        }
        return amount;
    }

    public Boolean checkRoomAvailability(RoomDates roomDate){
    if(datesRepo.findDatesByRoomId(roomDate.getRoomId(),roomDate.getDatesList()).size()>0){
        return true;
    }
    return false;
    }
}
