package com.example.booking_az.dto.requestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
public class HotelRequestDto {
    private String name;
    private String starRating;
    private String city;
    private String street;
    @NotNull(message = "Can not be null")
    private Integer roomCount;
    private Long id;
}
