package com.example.booking_az.dto.responseDto;

import com.example.booking_az.enumaration.OrderStatusEnum;
import com.example.booking_az.enumaration.RoomStatusEnum;
import com.example.booking_az.enumaration.RoomTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HotelResponseDto {
    private Long id;
    private String name;
    private String starRating;
    private String city;
    private String street;
    private Integer roomCount;
    private List<BookingDto> booking;
    private List<RoomDto> room;
    private List<ReviewDto> review;
    @Data
    public static class BookingDto {
        private Long id;
        private Date checkInDate;
        private Date checkOutDate;
        @Enumerated(value = EnumType.STRING)
        private OrderStatusEnum orderStatusEnum;
        private Double totalPrice;
        private Long orderNo;

    }
    @Data
    public static class RoomDto {
        private Long id;
        @Enumerated(EnumType.STRING)
        private RoomTypeEnum roomType;
        private Double pricePerNight;
        @Enumerated(EnumType.STRING)
        private RoomStatusEnum roomStatus;
        private Integer roomNo;
    }
    @Data
    public static class ReviewDto {
        private Long id;
        private String customer;
        private Double rating;
        private String comment;
        private Date dateCreated;

    }
}
