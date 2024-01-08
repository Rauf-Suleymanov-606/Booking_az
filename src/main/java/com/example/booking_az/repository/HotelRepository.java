package com.example.booking_az.repository;

import com.example.booking_az.entity.Hotel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    @EntityGraph(attributePaths = "booking")
    Optional<Hotel> findById(Long id);
}
