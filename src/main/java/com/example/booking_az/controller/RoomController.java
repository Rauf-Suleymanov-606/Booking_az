package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.requestDto.HotelRequestDto;
import com.example.booking_az.dto.requestDto.RoomRequestDto;
import com.example.booking_az.dto.responseDto.RoomResponseDto;
import com.example.booking_az.entity.Room;
import com.example.booking_az.service.impl.RoomServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Room> add(@Valid @RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roomServiceImpl.add(roomRequestDto));

//        if (bindingResult.hasErrors()) {
//            List<FieldError> errors = bindingResult.getFieldErrors();
//            StringBuilder errorMsg = new StringBuilder("Validation error(s): ");
//            for (FieldError error : errors) {
//                errorMsg.append(error.getDefaultMessage()).append("; ");
//            }
//            return ResponseEntity.badRequest().body(errorMsg);
//        }
//        roomServiceImpl.add(roomRequestDto);
//        return ResponseEntity.ok().body("Room succesfully added");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
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
