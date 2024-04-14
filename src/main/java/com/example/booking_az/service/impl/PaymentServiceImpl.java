package com.example.booking_az.service.impl;

import com.example.booking_az.dto.requestDto.PaymentRequestDto;
import com.example.booking_az.dto.responseDto.PaymentResponseDto;
import com.example.booking_az.entity.Payment;
import com.example.booking_az.exception.handler.NotFoundException;
import com.example.booking_az.mapper.PaymentMapper;
import com.example.booking_az.repository.PaymentRepository;
import com.example.booking_az.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponseDto getById(Long id) {
        Payment getPaymentById = paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found with this id: "+id));
        PaymentResponseDto getById = paymentMapper.entityToPaymentResponseDto(getPaymentById);
        log.info("Payment invoked with this id: ", id);
        return getById;
    }

    @Override
    public List<PaymentResponseDto> getAll() {
        List<Payment> payment = paymentRepository.findAll();
        List<PaymentResponseDto> paymentList = paymentMapper.entityToPaymentResponseDto(payment);
        return paymentList;
    }

    @Override
    public Payment add(PaymentRequestDto paymentRequestDto) {
        Payment payment = paymentMapper.paymentRequestDtoToEntity(paymentRequestDto);
        return paymentRepository.save(payment);
    }

    @Override
    public void update(Long id, PaymentRequestDto paymentRequestDto) {
        Payment updatedPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found with this id: "+id));
        paymentMapper.update(updatedPayment, paymentRequestDto);
        paymentRepository.save(updatedPayment);
        log.info("Payment updated with this id: ", id);

    }

    @Override
    public void delete(Long id) {
        Payment deletedPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found with this id: "+id));
        paymentRepository.delete(deletedPayment);
        log.info("Payment deleted with this id: ", id);
    }
}
