package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.ReviewRequestDto;
import com.example.booking_az.dto.responseDto.ReviewResponseDto;
import com.example.booking_az.entity.Review;
import com.example.booking_az.exception.ErrorResponse;
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
    public ResponseEntity<List<ReviewResponseDto>> getAll() {
        List<ReviewResponseDto> reviewList = reviewServiceImpl.getAll();
        return ResponseEntity.ok().body(reviewList);
    }

    @PostMapping
    public ResponseEntity<ErrorResponse> add(@Valid@RequestBody ReviewRequestDto reviewRequestDto) {
         reviewServiceImpl.add(reviewRequestDto);
         return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable Long id, @RequestBody ReviewRequestDto reviewRequestDto) {
        reviewServiceImpl.update(id, reviewRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        reviewServiceImpl.delete(id);
    }
}
