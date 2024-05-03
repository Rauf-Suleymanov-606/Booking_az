package com.example.booking_az.mapper;

import com.example.booking_az.dto.requestDto.ReviewRequestDto;
import com.example.booking_az.dto.responseDto.HotelByRatingDto;
import com.example.booking_az.dto.responseDto.ReviewResponseDto;
import com.example.booking_az.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewResponseDto entityToReviewResponseDto(Review review);

    List<HotelByRatingDto> reviewToHotelsByRatingDto(List<Review> review);


    List<ReviewResponseDto> entityToReviewResponseDto(List<Review> review);


    Review reviewRequestDtoToEntity(ReviewRequestDto reviewRequestDto);


    void update(@MappingTarget Review review, ReviewRequestDto reviewRequestDto);
}
