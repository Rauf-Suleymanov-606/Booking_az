package com.example.booking_az.dto.responseDto;

import com.example.booking_az.enumaration.OrderStatusEnum;
import com.example.booking_az.enumaration.RoomStatusEnum;
import com.example.booking_az.enumaration.RoomTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RoomResponseDto {
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoomTypeEnum roomType;
    private Double pricePerNight;
    @Enumerated(EnumType.STRING)
    private RoomStatusEnum roomStatus;
    private Integer roomNo;
    private CustomerDto customer;
    private HotelDto hotel;
    private BookingDto booking;

    @Data
    public static class CustomerDto {
        private Long id;
        private String name;
        private String surname;
        private String nationality;
        private String email;
        private String gender;

    }

    @Data
    public static class HotelDto {
        private Long id;
        private String name;
        private String starRating;
        private String city;
        private String street;
        private Integer roomCount;
    }

    @Data
    public static class BookingDto {
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        @Enumerated(value = EnumType.STRING)
        private OrderStatusEnum orderStatusEnum;
        private Double totalPrice;
        private Long orderNo;
    }
}
