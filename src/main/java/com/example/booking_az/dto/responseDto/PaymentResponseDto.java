package com.example.booking_az.dto.responseDto;

import com.example.booking_az.enumaration.OrderStatusEnum;
import com.example.booking_az.enumaration.PaymentMethodEnum;
import com.example.booking_az.enumaration.PaymentStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentResponseDto {
    private Long id;
    private Double amount;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatusEnum paymentStatusEnum;
    private Date paymentDate;
    @Enumerated(value = EnumType.STRING)
    private PaymentMethodEnum paymentMethod;
    private BookingDto booking;
    private CustomerDto customer;

    @Data
    public static class BookingDto {
        private Long id;
        private Date checkInDate;
        private Date checkOutDate;
        private Double totalPrice;
        private Long orderNo;

    }
    @Data
    public static class CustomerDto{
        private String name;
        private String surname;
        private String nationality;
        private String email;
        private String gender;
    }

}
