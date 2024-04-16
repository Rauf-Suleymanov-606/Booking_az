package com.example.booking_az.mapper;

import com.example.booking_az.dto.requestDto.HotelRequestDto;
import com.example.booking_az.dto.responseDto.HotelResponseDto;
import com.example.booking_az.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {


    @Mapping(source = "id", target = "id")
    Hotel hotelRequestDtoToEntity(HotelRequestDto hotelRequestDto);

    HotelResponseDto entityToHotelResponseDto(Hotel hotel);


    @Mapping(source = "id", target = "booking.booking")
    @Mapping(source = "id",target = "room.room")
    @Mapping(source = "id", target = "review.review")
    @Mapping(source = "id",target = "customer.customer")
    List<HotelResponseDto> entityToHotelResponseDto(List<Hotel> hotel);

    @Mapping(source = "id", target = "id")
    void update(@MappingTarget Hotel hotel, HotelRequestDto hotelRequestDto);
}
