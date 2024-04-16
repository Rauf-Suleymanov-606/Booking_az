package com.example.booking_az.repository;


import com.example.booking_az.entity.Booking;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    @EntityGraph(attributePaths = "customer")
    Optional<Booking> findById(Long id);


}



