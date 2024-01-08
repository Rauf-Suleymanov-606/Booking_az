package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.PaymentRequestDto;
import com.example.booking_az.dto.responseDto.PaymentResponseDto;
import com.example.booking_az.entity.Payment;
import com.example.booking_az.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentServiceImpl paymentServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> getById(@PathVariable Long id) {
        PaymentResponseDto getById = paymentServiceImpl.getById(id);
        return ResponseEntity.ok().body(getById);
    }

    @GetMapping
    public List<PaymentResponseDto> getAll() {
        List<PaymentResponseDto> paymentList = paymentServiceImpl.getAll();
        return paymentList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment add(@RequestBody PaymentRequestDto paymentRequestDto) {
        return paymentServiceImpl.add(paymentRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, PaymentRequestDto paymentRequestDto) {
        paymentServiceImpl.update(id, paymentRequestDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paymentServiceImpl.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
