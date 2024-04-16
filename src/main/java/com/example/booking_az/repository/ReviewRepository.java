package com.example.booking_az.repository;

import com.example.booking_az.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @EntityGraph(attributePaths = "hotel")
    Optional<Review> findById(Long id);


    List<Review> findByRatingGreaterThanEqual(Double rating);


}
