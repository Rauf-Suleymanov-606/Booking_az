package com.example.booking_az.service;

import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.requestDto.HotelRequestDto;
import com.example.booking_az.dto.responseDto.CustomerResponseDto;
import com.example.booking_az.dto.responseDto.HotelResponseDto;
import com.example.booking_az.entity.Customer;
import com.example.booking_az.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {
    HotelResponseDto getById(Long id);
    Hotel add(HotelRequestDto hotelRequestDto);
    void update(Long id, HotelRequestDto hotelRequestDto);
    void delete (Long id);
    List<HotelResponseDto> getAll();
}
