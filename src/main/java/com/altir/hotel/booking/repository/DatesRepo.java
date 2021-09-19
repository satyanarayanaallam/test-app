package com.altir.hotel.booking.repository;

import com.altir.hotel.booking.model.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface DatesRepo extends JpaRepository<Dates,Long> {

    @Query(value = "SELECT * from dates where ROOM_ROOM_ID=:roomId and ROOM_DATE IN :dateList",nativeQuery = true)
    List<Dates> findDatesByRoomId(@Param("roomId") Long roomId,@Param("dateList") List<Date> dateList);

    @Query(value = "SELECT * from dates where ROOM_DATE!=:date",nativeQuery = true)
    List<Dates> findAllAvailableRooms(@Param("date") Date date);

    @Query(value = "SELECT * from dates where ROOM_DATE=:date",nativeQuery = true)
    List<Dates> findAllOccupiedRooms(@Param("date") Date date);
}
