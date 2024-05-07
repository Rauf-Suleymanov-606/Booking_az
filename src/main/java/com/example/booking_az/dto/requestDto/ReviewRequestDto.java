package com.example.booking_az.dto.requestDto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewRequestDto {
    private String customer;
    @DecimalMax(value = "10.0",inclusive = true,message = "Rating must be less than or equal to 10.0 !")
    @DecimalMin(value = "1.0",inclusive = true,message = "Rating must be greater than or equal to 1.0 !")
    private Double rating;
    private String comment;
    private Date dateCreated;
    private Long hotelId;
}
