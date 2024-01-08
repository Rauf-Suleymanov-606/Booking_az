package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.ReviewRequestDto;
import com.example.booking_az.dto.responseDto.ReviewResponseDto;
import com.example.booking_az.entity.Review;
import com.example.booking_az.service.impl.ReviewServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl reviewServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getById(@PathVariable Long id) {
        ReviewResponseDto getReviewById = reviewServiceImpl.getById(id);
        return ResponseEntity.ok().body(getReviewById);
    }

    @GetMapping
    public List<ReviewResponseDto> getAll() {
        List<ReviewResponseDto> reviewList = reviewServiceImpl.getAll();
        return reviewList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review add(@RequestBody ReviewRequestDto reviewRequestDto){
     return reviewServiceImpl.add(reviewRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ReviewRequestDto reviewRequestDto) {
        reviewServiceImpl.update(id, reviewRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        reviewServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
