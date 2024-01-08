package com.example.booking_az.mapper;

import com.example.booking_az.dto.requestDto.ReviewRequestDto;
import com.example.booking_az.dto.responseDto.ReviewResponseDto;
import com.example.booking_az.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewResponseDto entityToReviewResponseDto(Review review);

    @Mapping(source = "hotelId", target = "hotel.hotel")
    List<ReviewResponseDto> entityToReviewResponseDto(List<Review> review);

    @Mapping(source = "hotelId", target = "hotel.id")
    Review reviewRequestDtoToEntity(ReviewRequestDto reviewRequestDto);

    @Mapping(source = "hotelId", target = "hotel.id")
    void update(@MappingTarget Review review, ReviewRequestDto reviewRequestDto);
}
