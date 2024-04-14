package com.example.booking_az.dto.responseDto;

import com.example.booking_az.enumaration.OrderStatusEnum;
import com.example.booking_az.enumaration.PaymentMethodEnum;
import com.example.booking_az.enumaration.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class BookingResponseDto {
    private Long id;
    private Date checkInDate;
    private Date checkOutDate;
    @Enumerated(value = EnumType.STRING)
    private OrderStatusEnum orderStatusEnum;
    private Double totalPrice;
    private Long orderNo;
    private CustomerDto customer;
    private HotelDto hotel;
    private PaymentDto payment;


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
        private String roomCount;

    }

    @Data
    public static class PaymentDto {
        private Double amount;
        @Enumerated(value = EnumType.STRING)
        private PaymentStatusEnum paymentStatusEnum;
        private Date paymentDate;
        @Enumerated(value = EnumType.STRING)
        private PaymentMethodEnum paymentMethod;
    }
}

