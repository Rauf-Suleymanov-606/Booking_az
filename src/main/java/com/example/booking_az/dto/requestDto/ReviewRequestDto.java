package com.example.booking_az.dto.requestDto;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewRequestDto {
    private String customer;
    private Double rating;
    private String comment;
    private Date dateCreated;
    private Long hotelId;
}
