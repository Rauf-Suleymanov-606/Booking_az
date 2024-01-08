package com.example.booking_az.repository;

import com.example.booking_az.entity.Payment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @EntityGraph(attributePaths = "booking")
    @Override
    Optional<Payment> findById(Long id);
}
