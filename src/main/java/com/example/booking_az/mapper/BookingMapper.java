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
    @Mapping(source = "customerId", target = "customer.id")
    Booking bookingRequestDtoToEntity(BookingRequestDto bookingRequestDto);

    BookingResponseDto entityToBookingResponseDto(Booking bookings);

    @Mapping(source = "customerId", target = "customer.customer")
    List<BookingResponseDto> entityToBookingResponseDto(List<Booking> booking);

    @Mapping(source = "customerId", target = "customer.id")
    void update(@MappingTarget Booking booking, BookingRequestDto bookingRequestDto);
}
