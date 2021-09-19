package com.altir.hotel.booking.service;

import com.altir.hotel.booking.exceptions.ResourceNotFoundException;
import com.altir.hotel.booking.model.Dates;
import com.altir.hotel.booking.model.Room;
import com.altir.hotel.booking.repository.DatesRepo;
import com.altir.hotel.booking.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private DatesRepo datesRepo;

    @Override
    public Room addRoom(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public Room getRoomById(Long roomId) {
        Optional<Room> room=roomRepo.findById(roomId);
        if(room.isPresent()){
            return room.get();
        }
        throw new ResourceNotFoundException("Room Not found");
    }

    @Override
    public void removeRoom(Long roomId) {
        Optional<Room> room=roomRepo.findById(roomId);
        if(room.isPresent()){
            roomRepo.deleteById(roomId);
        }
        throw new ResourceNotFoundException("Room Not found");
    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
        Optional<Room> ro=roomRepo.findById(roomId);
        if(ro.isPresent()){
            Room em=ro.get();
            em.setRoomNo(room.getRoomNo());
            em.setRoomRent(room.getRoomRent());
            em.setRoomType(room.getRoomType());
            em.setFloor(room.getFloor());
            return roomRepo.save(em);
        }
        throw new ResourceNotFoundException("Room Not found");
    }

    @Override
    public Room changeRoomPrice(Long roomId, Long roomPrice) {
        Optional<Room> ro=roomRepo.findById(roomId);
        if(ro.isPresent()){
            Room em=ro.get();
            em.setRoomRent(roomPrice);
            return roomRepo.save(em);
        }
        throw new ResourceNotFoundException("Room Not found");
    }

    @Override
    public Long fetchTotalRevenue() {
        Long revenue=0l;
        List<Dates> datesList=datesRepo.findAll();
        for(Dates dates:datesList){
            revenue=revenue+dates.getRoom().getRoomRent();
        }
        return revenue;
    }
}
