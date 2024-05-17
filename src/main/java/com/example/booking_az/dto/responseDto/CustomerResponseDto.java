package com.example.booking_az.dto.responseDto;

import com.example.booking_az.enumaration.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CustomerResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String nationality;
    private String email;
    private String gender;
    private List<BookingDto> booking;
    private List<RoomDto> room;
    private HotelDto hotel;
    private List<PaymentDto> payment;

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
    public static class HotelDto {
        private Long id;
        private String name;
        private String starRating;
        private String city;
        private String street;
        private Integer roomCount;
    }

    @Data
    public static class PaymentDto {
        private Double amount;
        @Enumerated(value = EnumType.STRING)
        private PaymentStatusEnum paymentStatus;
        private Date paymentDate;
        @Enumerated(value = EnumType.STRING)
        private PaymentMethodEnum paymentMethod;
    }

}
