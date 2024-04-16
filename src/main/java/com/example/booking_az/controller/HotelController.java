package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.HotelRequestDto;
import com.example.booking_az.dto.responseDto.HotelByRatingDto;
import com.example.booking_az.dto.responseDto.HotelResponseDto;
import com.example.booking_az.service.impl.HotelServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelServiceImpl hotelServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDto> getById(@PathVariable Long id) {
        HotelResponseDto getById = hotelServiceImpl.getById(id);
        return ResponseEntity.ok().body(getById);

    }
    @GetMapping("/{id}/ByRating")
    public List<HotelByRatingDto> getHotelsByRating(Double rating){
        return hotelServiceImpl.getHotelsByRating(rating);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody HotelRequestDto hotelRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder errorMsg = new StringBuilder("Validation error(s): ");
            for (FieldError error : errors) {
                errorMsg.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errorMsg);
        }
        hotelServiceImpl.add(hotelRequestDto);
        return ResponseEntity.ok().body("Hotel succesfully added");
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody HotelRequestDto hotelRequestDto) {
        hotelServiceImpl.update(id, hotelRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hotelServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public List<HotelResponseDto> getAllHotels() {
        List<HotelResponseDto> hotelList = hotelServiceImpl.getAll();
        return hotelList;
    }
}
