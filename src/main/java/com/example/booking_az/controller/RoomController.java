package com.example.booking_az.controller;
import com.example.booking_az.dto.requestDto.RoomRequestDto;
import com.example.booking_az.dto.responseDto.RoomResponseDto;
import com.example.booking_az.entity.Room;
import com.example.booking_az.exception.ErrorResponse;
import com.example.booking_az.service.impl.RoomServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomServiceImpl roomServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> getById(@PathVariable Long id) {
        RoomResponseDto getById = roomServiceImpl.getById(id);
        return ResponseEntity.ok().body(getById);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Room add(@Valid @RequestBody RoomRequestDto roomRequestDto) {
        return roomServiceImpl.add(roomRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody RoomRequestDto roomRequestDto) {
        roomServiceImpl.update(id, roomRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roomServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<RoomResponseDto>> getAll() {
        List<RoomResponseDto> roomList = roomServiceImpl.getAll();
        return ResponseEntity.ok().body(roomList);
    }
}
