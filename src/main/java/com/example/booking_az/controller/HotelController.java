package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.requestDto.HotelRequestDto;
import com.example.booking_az.dto.responseDto.HotelByRatingDto;
import com.example.booking_az.dto.responseDto.HotelResponseDto;
import com.example.booking_az.entity.Hotel;
import com.example.booking_az.entity.projection.HotelProjection;
import com.example.booking_az.service.impl.HotelServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.booking_az.exception.ErrorResponse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelServiceImpl hotelServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDto> getById(@PathVariable Long id) {
        HotelResponseDto getById = hotelServiceImpl.getById(id);
        return ResponseEntity.ok().body(getById);

    }

    @GetMapping("/{reviewRating}/ByReviewRating")
    public ResponseEntity<List<HotelByRatingDto>> getHotelsByReviewRating(@PathVariable Double reviewRating) {
        return ResponseEntity.ok().body(hotelServiceImpl.getHotelsByReviewRating(reviewRating));
    }

    @GetMapping("/{starRating}/ByStarRating")
    public ResponseEntity<List<HotelProjection>> getHotelsByStarRating(@PathVariable String starRating) {
        return ResponseEntity.ok().body(hotelServiceImpl.getHotelsByStarRating(starRating));
    }

    @PostMapping
    public ResponseEntity<ErrorResponse> add(@Valid @RequestBody HotelRequestDto hotelRequestDto) {
        hotelServiceImpl.add(hotelRequestDto);
        return ResponseEntity.ok().build();
    }
        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.CREATED)
        public void update (@PathVariable Long id, @RequestBody HotelRequestDto hotelRequestDto){
            hotelServiceImpl.update(id, hotelRequestDto);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete (@PathVariable Long id){
            hotelServiceImpl.delete(id);
        }

        @GetMapping
        public ResponseEntity<List<HotelResponseDto>> getAllHotels () {
            List<HotelResponseDto> hotelList = hotelServiceImpl.getAll();
            return ResponseEntity.ok().body(hotelList);
        }
    }
