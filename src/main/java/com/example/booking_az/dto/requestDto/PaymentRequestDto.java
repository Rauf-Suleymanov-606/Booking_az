package com.example.booking_az.dto.requestDto;

import com.example.booking_az.entity.Booking;
import com.example.booking_az.enumaration.PaymentMethodEnum;
import com.example.booking_az.enumaration.PaymentStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentRequestDto {
    private Double amount;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
    private Date paymentDate;
    @Enumerated(value = EnumType.STRING)
    private PaymentMethodEnum paymentMethod;
    private Long bookingId;
    private Long customerId;
}
