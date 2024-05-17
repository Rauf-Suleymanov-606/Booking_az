package com.example.booking_az.mapper;

import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.responseDto.BookingByCustomerDto;
import com.example.booking_az.dto.responseDto.CustomerResponseDto;
import com.example.booking_az.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer customerRequestDtoToEntity(CustomerRequestDto customerRequestDto);

    CustomerResponseDto entityToCustomerResponseDto(Customer customer);

    BookingByCustomerDto customerToBookingByCustomer(Customer customer);


    List<CustomerResponseDto> entityToCustomerResponseDto(List<Customer> customer);

    void update(@MappingTarget Customer customer, CustomerRequestDto customerRequestDto);
}
