package com.example.booking_az.service.impl;

import com.example.booking_az.dto.requestDto.RoomRequestDto;
import com.example.booking_az.dto.responseDto.RoomResponseDto;
import com.example.booking_az.entity.Room;
import com.example.booking_az.exception.handler.NotFoundException;
import com.example.booking_az.mapper.RoomMapper;
import com.example.booking_az.repository.RoomRepository;
import com.example.booking_az.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomResponseDto getById(Long id) {
        Room getRoomById = roomRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Room not found with this id: "+id));
        RoomResponseDto getById = roomMapper.entityToHotelResponseDto(getRoomById);
        log.info("Room invoked with this id",id);
        return getById;

    }

    @Override
    public Room add(RoomRequestDto roomRequestDto) {
        Room room = roomMapper.roomRequestDtoToEntity(roomRequestDto);
        return roomRepository.save(room);
    }

    @Override
    public void update(Long id, RoomRequestDto roomRequestDto) {
        Room updatedRoom = roomRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Room not found with this id: "+id));
        roomMapper.update(updatedRoom, roomRequestDto);
        roomRepository.save(updatedRoom);
        log.info("Room updated with this id",id);
    }

    @Override
    public void delete(Long id) {
        Room deletedRoom = roomRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Room not found with this id: "+id));
        roomRepository.delete(deletedRoom);
        log.info("Room deleted with this id",id);
    }

    @Override
    public List<RoomResponseDto> getAll() {
        List<Room> room = roomRepository.findAll();
        List<RoomResponseDto> roomList = roomMapper.entityToHotelResponseDto(room);
        return roomList;
    }


}
