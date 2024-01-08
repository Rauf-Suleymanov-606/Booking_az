package com.example.booking_az.dto.requestDto;

import com.example.booking_az.enumaration.OrderStatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;


@Data
public class BookingRequestDto {
    private Date checkInDate;
    private Date checkOutDate;
    @Enumerated(value = EnumType.STRING)
    private OrderStatusEnum orderStatusEnum;
    private Long totalPrice;
    private Long orderNo;
    private Long customerId;
    private Long hotelId;

}

