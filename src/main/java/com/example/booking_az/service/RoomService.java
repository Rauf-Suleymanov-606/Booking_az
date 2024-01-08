package com.example.booking_az.service;

import com.example.booking_az.dto.requestDto.RoomRequestDto;
import com.example.booking_az.dto.responseDto.RoomResponseDto;
import com.example.booking_az.entity.Room;

import java.util.List;

public interface RoomService {
    RoomResponseDto getById(Long id);

    Room add(RoomRequestDto roomRequestDto);

    void update(Long id, RoomRequestDto roomRequestDto);

    void delete(Long id);

    List<RoomResponseDto> getAll();

}
