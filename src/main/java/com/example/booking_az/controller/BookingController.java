package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.BookingRequestDto;
import com.example.booking_az.dto.responseDto.BookingByCustomerDto;
import com.example.booking_az.dto.responseDto.BookingResponseDto;
import com.example.booking_az.entity.Booking;
import com.example.booking_az.entity.Payment;
import com.example.booking_az.service.impl.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookings/admin")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDto> getById(@PathVariable Long id) {
        BookingResponseDto getById = bookingServiceImpl.getById(id);
        return ResponseEntity.ok().body(getById);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<BookingByCustomerDto> getBookingByCustomerId(@PathVariable Long customerId) {
        BookingByCustomerDto getByCustomerId = bookingServiceImpl.getBookingByCustomerId(customerId);
        return ResponseEntity.ok().body(getByCustomerId);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking add(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingServiceImpl.add(bookingRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody BookingRequestDto bookingRequestDto) {
        bookingServiceImpl.update(id, bookingRequestDto);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookingServiceImpl.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookingResponseDto> getAll() {
        List<BookingResponseDto> bookingList = bookingServiceImpl.getAll();
        return bookingList;
    }
}
