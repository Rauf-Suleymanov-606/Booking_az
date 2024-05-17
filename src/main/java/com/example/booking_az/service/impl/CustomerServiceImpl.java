package com.example.booking_az.service.impl;


import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.responseDto.CustomerResponseDto;
import com.example.booking_az.entity.Customer;
import com.example.booking_az.entity.projection.CustomerProjection;
import com.example.booking_az.exception.handler.NotFoundException;
import com.example.booking_az.mapper.BookingMapper;
import com.example.booking_az.mapper.CustomerMapper;
import com.example.booking_az.repository.BookingRepository;
import com.example.booking_az.repository.CustomerRepository;
import com.example.booking_az.repository.HotelRepository;
import com.example.booking_az.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public CustomerResponseDto getById(Long id) {
        Customer getById = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with this id: " + id));
        CustomerResponseDto customerResponseDto = customerMapper.entityToCustomerResponseDto(getById);
        return customerResponseDto;
    }

    @Override
    public Customer add(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerRequestDtoToEntity(customerRequestDto);
       return customerRepository.save(customer);
    }

    @Override
    public void update(Long id, CustomerRequestDto customerRequestDto) {
        Customer updatedCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with this id: " + id));
        customerMapper.update(updatedCustomer, customerRequestDto);
        customerRepository.save(updatedCustomer);
        log.info("Booking updated with this id= " + id);
    }

    @Override
    public void delete(Long id) {
        Customer deletedCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with this id: " + id));
        customerRepository.delete(deletedCustomer);
        log.info("Booking deleted with this id= ", id);
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos = customerMapper.entityToCustomerResponseDto(customerList);
        return customerResponseDtos;
    }

    @Override
    public List<CustomerProjection> getNameByNationality(String nationality) {
        List<CustomerProjection> customers = customerRepository.findByNationality(nationality);
        if (customers.isEmpty()) {
            throw new NotFoundException("Name not found with this nationality!");
        }
        return customers;
    }
}
