package com.altir.hotel.booking.controller;

import com.altir.hotel.booking.model.Booking;
import com.altir.hotel.booking.model.BookingForm;
import com.altir.hotel.booking.model.Room;
import com.altir.hotel.booking.service.AdminService;
import com.altir.hotel.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class WebController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @PostMapping("/admin/addRooms")
    public Room addRooms(@RequestBody Room room){
        return adminService.addRoom(room);
    }

    @GetMapping("/admin/viewRoom/{roomId}")
    public ResponseEntity<Room> addRooms(@PathVariable long roomId){
        return ResponseEntity.ok(adminService.getRoomById(roomId));
    }

    @DeleteMapping("/admin/removeRoom/{roomId}")
    public void removeRooms(@PathVariable long roomId){
        adminService.removeRoom(roomId);
    }

    @PutMapping("/admin/updateRoom/{roomId}")
    public Room updateRoom(@PathVariable long roomId, @RequestBody Room room){
        return adminService.updateRoom(roomId,room);
    }

    @PostMapping("/users/bookRooms/")
    public Booking bookRooms(@RequestBody BookingForm bookingForm){
        return userService.bookRoom(bookingForm);
    }

    @GetMapping("/users/viewRooms/")
    public List<Room> viewRooms(){
        return userService.getRooms();
    }

    @GetMapping("/users/allAvailableRooms/{date}")
    public List<Room> getAllAvailableRooms(@PathVariable("date") @DateTimeFormat(pattern = "dd-mm-yyyy") Date date){
        return userService.getAllVailableRooms(date);
    }

    @GetMapping("/users/allBookedRooms/{date}")
    public List<Room> getAllBookedRooms(@PathVariable("date") @DateTimeFormat(pattern = "dd-mm-yyyy") Date date){
        return userService.getAllBookedRooms(date);
    }

    @GetMapping("/user/fetchRoomPricesBookedByUser/{userId}")
    public Long fetchRoomPricesOfUser(@PathVariable long userId ){
        return userService.fetchRoomPricesOfUser(userId);
    }

    @PutMapping("/admin/changeRoomPrice/{roomId}/{roomPrice}")
    public Room changeRoomPrice(@PathVariable Long roomId,@PathVariable Long roomPrice){
        return adminService.changeRoomPrice(roomId,roomPrice);
    }

    @GetMapping("/admin/fetchTotalRevenue/")
    public Long fetchTotalRevenue(){
        return adminService.fetchTotalRevenue();
    }
}
