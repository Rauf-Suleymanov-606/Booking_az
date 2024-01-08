package com.example.booking_az.repository;

import com.example.booking_az.entity.Room;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    @EntityGraph(attributePaths = "customer")
    Optional<Room> findById(Long id);
}
