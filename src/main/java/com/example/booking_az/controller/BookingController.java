package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.BookingRequestDto;
import com.example.booking_az.dto.responseDto.BookingResponseDto;
import com.example.booking_az.entity.Booking;
import com.example.booking_az.service.impl.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;

    @GetMapping("/{id}")
    public BookingResponseDto getById(@PathVariable Long id) {
        BookingResponseDto getById = bookingServiceImpl.getById(id);
        return getById;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking add(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingServiceImpl.add(bookingRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody BookingRequestDto bookingRequestDto) {
        bookingServiceImpl.update(id, bookingRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        bookingServiceImpl.delete(id);
    }

    @GetMapping
    public List<BookingResponseDto> getAll() {
        List<BookingResponseDto> bookingList = bookingServiceImpl.getAll();
        return bookingList;
    }
}
