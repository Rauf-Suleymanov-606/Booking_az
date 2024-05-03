package com.example.booking_az.mapper;


import com.example.booking_az.dto.requestDto.BookingRequestDto;
import com.example.booking_az.dto.responseDto.BookingResponseDto;
import com.example.booking_az.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking bookingRequestDtoToEntity(BookingRequestDto bookingRequestDto);

    BookingResponseDto entityToBookingResponseDto(Booking booking);


    List<BookingResponseDto> entityToBookingResponseDto(List<Booking> booking);

    void update(@MappingTarget Booking booking, BookingRequestDto bookingRequestDto);


}



