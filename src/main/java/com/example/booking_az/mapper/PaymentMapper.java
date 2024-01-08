package com.example.booking_az.mapper;

import com.example.booking_az.dto.requestDto.PaymentRequestDto;
import com.example.booking_az.dto.responseDto.PaymentResponseDto;
import com.example.booking_az.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentResponseDto entityToPaymentResponseDto(Payment payment);
    @Mapping(source = "bookingId",target = "booking.booking")
    List<PaymentResponseDto> entityToPaymentResponseDto(List<Payment> payment);
    @Mapping(source = "bookingId",target = "booking.id")
    Payment paymentRequestDtoToEntity(PaymentRequestDto paymentRequestDto);
    @Mapping(source = "bookingId",target = "booking.id")
    void update(@MappingTarget Payment payment, PaymentRequestDto paymentRequestDto);

}
