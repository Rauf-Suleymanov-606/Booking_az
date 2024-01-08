package com.example.booking_az.service;

import com.example.booking_az.dto.requestDto.ReviewRequestDto;
import com.example.booking_az.dto.responseDto.ReviewResponseDto;
import com.example.booking_az.entity.Review;

import java.util.List;

public interface ReviewService {
    ReviewResponseDto getById(Long id);

    List<ReviewResponseDto> getAll();

    Review add(ReviewRequestDto reviewRequestDto);

    void update(Long id, ReviewRequestDto reviewRequestDto);

    void delete(Long id);
}
