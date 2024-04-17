package com.example.booking_az.dto.responseDto;

import lombok.Data;

@Data
public class HotelByRatingDto {
    private Double rating;
    private HotelDto hotel;
    @Data
    public  static class HotelDto{
        private String name;
        private String starRating;
        private String city;
        private String street;
        private Integer roomCount;
    }
}
