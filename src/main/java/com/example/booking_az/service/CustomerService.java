package com.example.booking_az.service;


import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.responseDto.CustomerResponseDto;
import com.example.booking_az.entity.Customer;
import com.example.booking_az.entity.projection.CustomerProjection;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto getById(Long id);
    Customer add(CustomerRequestDto customerRequestDto);
    void update(Long id, CustomerRequestDto customerRequestDto);
    void delete (Long id);
    List<CustomerResponseDto> getAll();
    List<CustomerProjection> getNameByNationality(String nationality);

}
