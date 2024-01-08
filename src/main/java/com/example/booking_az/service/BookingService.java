package com.example.booking_az.service;

import com.example.booking_az.dto.requestDto.BookingRequestDto;
import com.example.booking_az.dto.responseDto.BookingResponseDto;
import com.example.booking_az.entity.Booking;

import java.util.List;

public interface BookingService {
    BookingResponseDto getById(Long id);

    Booking add(BookingRequestDto bookingRequestDto);

    void update(Long id, BookingRequestDto bookingRequestDto);

    void delete(Long id);

    List<BookingResponseDto> getAll();
}
