package com.altir.hotel.booking.repository;

import com.altir.hotel.booking.model.Booking;
import com.altir.hotel.booking.model.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {

    @Query(value = "SELECT * from Booking where user_id=:userId",nativeQuery = true)
    List<Booking> findByUserId(@Param("userId") Long userId);
}
