package com.example.booking_az.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewResponseDto {
    private Long id;
    private String customer;
    private Double rating;
    private String comment;
    private Date dateCreated;
    private HotelDto hotel;

    @Data
    public static class HotelDto {
        private String name;
        private String starRating;
        private String city;
        private String street;
    }
}

