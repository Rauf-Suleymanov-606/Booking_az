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


    Hotel hotelRequestDtoToEntity(HotelRequestDto hotelRequestDto);

    HotelResponseDto entityToHotelResponseDto(Hotel hotel);


    List<HotelResponseDto> entityToHotelResponseDto(List<Hotel> hotel);

    void update(@MappingTarget Hotel hotel, HotelRequestDto hotelRequestDto);
}
