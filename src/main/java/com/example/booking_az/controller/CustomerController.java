package com.example.booking_az.controller;


import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.responseDto.CustomerResponseDto;
import com.example.booking_az.dto.responseDto.HotelResponseDto;
import com.example.booking_az.entity.Customer;
import com.example.booking_az.entity.projection.CustomerProjection;
import com.example.booking_az.exception.ErrorResponse;
import com.example.booking_az.service.impl.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getById(@PathVariable Long id) {
        CustomerResponseDto getById = customerService.getById(id);
        return ResponseEntity.ok().body(getById);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer add(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.add(customerRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody CustomerRequestDto customerRequestDto) {
        customerService.update(id, customerRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll() {
        List<CustomerResponseDto> customerList = customerService.getAll();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/{nationality}/customers")
    public ResponseEntity<List<CustomerProjection>> getNameByNationality(@PathVariable String nationality) {
        List<CustomerProjection> customerInfo = customerService.getNameByNationality(nationality);
        return ResponseEntity.ok().body(customerInfo);
    }

}
