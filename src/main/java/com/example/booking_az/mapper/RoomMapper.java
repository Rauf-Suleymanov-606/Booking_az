package com.example.booking_az.mapper;

import com.example.booking_az.dto.requestDto.RoomRequestDto;
import com.example.booking_az.dto.responseDto.RoomResponseDto;
import com.example.booking_az.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomResponseDto entityToHotelResponseDto(Room room);
    @Mapping(source = "customerId", target = "customer.customer")
    @Mapping(source = "customerId", target = "hotel.hotel")
    List<RoomResponseDto> entityToHotelResponseDto(List<Room> room);
    @Mapping(source = "customerId", target = "customer.id")
    Room roomRequestDtoToEntity(RoomRequestDto roomRequestDto);

    @Mapping(source = "customerId", target = "customer.id")
    void update(@MappingTarget Room room, RoomRequestDto roomRequestDto);
}
