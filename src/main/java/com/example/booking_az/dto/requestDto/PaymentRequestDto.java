package com.example.booking_az.dto.requestDto;

import com.example.booking_az.enumaration.PaymentMethodEnum;
import com.example.booking_az.enumaration.PaymentStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PaymentRequestDto {
    private Double amount;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
    @NotNull(message = "Created date can not be null!")
    @DateTimeFormat(pattern = "Date format must follow yyyy-MM-dd!")
    private Date paymentDate;
    @Enumerated(value = EnumType.STRING)
    private PaymentMethodEnum paymentMethod;
    private Long bookingId;
    private Long customerId;
}
