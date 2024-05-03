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

    List<RoomResponseDto> entityToHotelResponseDto(List<Room> room);

    Room roomRequestDtoToEntity(RoomRequestDto roomRequestDto);


    void update(@MappingTarget Room room, RoomRequestDto roomRequestDto);
}
