package com.example.booking_az.controller;

import com.example.booking_az.dto.requestDto.PaymentRequestDto;
import com.example.booking_az.dto.responseDto.PaymentResponseDto;
import com.example.booking_az.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments/management")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentServiceImpl paymentServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> getById(@PathVariable Long id) {
        PaymentResponseDto getById = paymentServiceImpl.getById(id);
        return ResponseEntity.ok().body(getById);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDto>> getAll() {
        List<PaymentResponseDto> paymentList = paymentServiceImpl.getAll();
        return ResponseEntity.ok().body(paymentList);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody PaymentRequestDto paymentRequestDto) {
        paymentServiceImpl.add(paymentRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable Long id, PaymentRequestDto paymentRequestDto) {
        paymentServiceImpl.update(id, paymentRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        paymentServiceImpl.delete(id);
    }

}
