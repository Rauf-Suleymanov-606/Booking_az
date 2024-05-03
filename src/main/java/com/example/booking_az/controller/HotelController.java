package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.HotelRequestDto;
import com.example.booking_az.dto.responseDto.HotelByRatingDto;
import com.example.booking_az.dto.responseDto.HotelResponseDto;
import com.example.booking_az.entity.projection.HotelProjection;
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

    @GetMapping("/{reviewRating}/ByReviewRating")
    public ResponseEntity<List<HotelByRatingDto>> getHotelsByReviewRating(@PathVariable Double reviewRating) {
        return ResponseEntity.ok().body(hotelServiceImpl.getHotelsByReviewRating(reviewRating));
    }

    @GetMapping("/{starRating}/ByStarRating")
    public ResponseEntity<List<HotelProjection>> getHotelsByStarRating(@PathVariable String starRating) {
        return ResponseEntity.ok().body(hotelServiceImpl.getHotelsByStarRating(starRating));
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
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable Long id, @RequestBody HotelRequestDto hotelRequestDto) {
        hotelServiceImpl.update(id, hotelRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        hotelServiceImpl.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAllHotels() {
        List<HotelResponseDto> hotelList = hotelServiceImpl.getAll();
        return ResponseEntity.ok().body(hotelList);
    }
}
