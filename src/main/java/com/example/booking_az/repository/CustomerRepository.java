package com.example.booking_az.repository;

import com.example.booking_az.entity.Customer;
import com.example.booking_az.entity.projection.CustomerProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @EntityGraph(attributePaths = "booking")
    Optional<Customer> findById(Long id);

    List<CustomerProjection> findByNationality(String nationality);

}
