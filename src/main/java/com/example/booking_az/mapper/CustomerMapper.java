package com.example.booking_az.mapper;

import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.responseDto.CustomerResponseDto;
import com.example.booking_az.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "id", target = "id")
    Customer customerRequestDtoToEntity(CustomerRequestDto customerRequestDto);

    CustomerResponseDto entityToCustomerResponseDto(Customer customer);

    @Mapping(source = "id", target = "booking.booking")
    @Mapping(source = "id",target = "room.room")
    List<CustomerResponseDto> entityToCustomerResponseDto(List<Customer> customer);

    @Mapping(source = "id", target = "id")
    void update(@MappingTarget Customer customer, CustomerRequestDto customerRequestDto);
}
