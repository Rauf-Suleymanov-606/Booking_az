package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.BookingRequestDto;
import com.example.booking_az.dto.responseDto.BookingByCustomerDto;
import com.example.booking_az.dto.responseDto.BookingResponseDto;
import com.example.booking_az.entity.Booking;
import com.example.booking_az.service.impl.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDto> getById(@PathVariable Long id) {
        BookingResponseDto getById = bookingServiceImpl.getById(id);
        return ResponseEntity.ok().body(getById);
    }
    @GetMapping("/{id}/byCustomerId")
    public ResponseEntity< BookingByCustomerDto> getBookingByCustomerId(@PathVariable Long id){
        BookingByCustomerDto getByCustomerId=bookingServiceImpl.getBookingByCustomerId(id);
        return ResponseEntity.ok().body(getByCustomerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking add(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingServiceImpl.add(bookingRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable Long id, @RequestBody BookingRequestDto bookingRequestDto) {
        bookingServiceImpl.update(id, bookingRequestDto);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        bookingServiceImpl.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookingResponseDto> getAll() {
        List<BookingResponseDto> bookingList = bookingServiceImpl.getAll();
        return bookingList;
    }
}
