package com.example.booking_az.service;

import com.example.booking_az.dto.requestDto.HotelRequestDto;
import com.example.booking_az.dto.responseDto.HotelResponseDto;
import com.example.booking_az.dto.responseDto.HotelByRatingDto;
import com.example.booking_az.entity.Hotel;
import com.example.booking_az.entity.projection.HotelProjection;

import java.util.List;


public interface HotelService {
    HotelResponseDto getById(Long id);
    List<HotelByRatingDto> getHotelsByReviewRating(Double reviewRating);
    List<HotelProjection> getHotelsByStarRating(String starRating);
    Hotel add(HotelRequestDto hotelRequestDto);
    void update(Long id, HotelRequestDto hotelRequestDto);
    void delete (Long id);
    List<HotelResponseDto> getAll();
}
