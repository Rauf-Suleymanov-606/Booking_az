package com.example.booking_az.service.impl;

import com.example.booking_az.dto.requestDto.BookingRequestDto;
import com.example.booking_az.dto.responseDto.BookingResponseDto;
import com.example.booking_az.entity.Booking;
import com.example.booking_az.exception.handler.BookingNotFoundException;
import com.example.booking_az.exception.handler.CustomerNotFoundException;
import com.example.booking_az.mapper.BookingMapper;
import com.example.booking_az.repository.BookingRepository;
import com.example.booking_az.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingResponseDto getById(Long id) {
        Booking getById = bookingRepository.findById(id).orElseThrow(()->new BookingNotFoundException("Booking not found with this id"));
        BookingResponseDto bookingResponseDto = bookingMapper.entityToBookingResponseDto(getById);
        return bookingResponseDto;
    }

    @Override
    public Booking add(BookingRequestDto bookingRequestDto) {
        Booking bookings = bookingMapper.bookingRequestDtoToEntity(bookingRequestDto);
        return bookingRepository.save(bookings);
    }

    @Override
    public void update(Long id, BookingRequestDto bookingRequestDto) {
        Booking updatedBooking = bookingRepository.findById(id).orElseThrow(()->new BookingNotFoundException("Booking not found with this id"));
        bookingMapper.update(updatedBooking, bookingRequestDto);
        bookingRepository.save(updatedBooking);
        log.info("Booking updated with this id= " + id);
    }

    @Override
    public void delete(Long id) {
        Booking deletedBooking = bookingRepository.findById(id).orElseThrow(()-> new BookingNotFoundException("Booking not found with this id"));
        bookingRepository.delete(deletedBooking);
        log.info("Booking deleted with this id= ", id);
    }

    @Override
    public List<BookingResponseDto> getAll() {
        List<Booking> bookingList = bookingRepository.findAll();
        List<BookingResponseDto> bookingResponseDtos = bookingMapper.entityToBookingResponseDto(bookingList);
        return bookingResponseDtos;
    }

}
