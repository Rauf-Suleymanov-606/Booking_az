package com.example.booking_az.service;

import com.example.booking_az.dto.requestDto.PaymentRequestDto;
import com.example.booking_az.dto.responseDto.PaymentResponseDto;
import com.example.booking_az.entity.Payment;

import java.util.List;

public interface PaymentService {

    PaymentResponseDto getById(Long id);
    List<PaymentResponseDto> getAll();
    Payment add(PaymentRequestDto paymentRequestDto);
    void update(Long id, PaymentRequestDto paymentRequestDto);
    void delete(Long id);


}
