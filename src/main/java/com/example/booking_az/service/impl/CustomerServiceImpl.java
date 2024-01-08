package com.example.booking_az.service.impl;

import com.example.booking_az.dto.requestDto.CustomerRequestDto;
import com.example.booking_az.dto.responseDto.CustomerResponseDto;
import com.example.booking_az.entity.Customer;
import com.example.booking_az.entity.projection.CustomerProjection;
import com.example.booking_az.exception.handler.CustomerNotFoundException;
import com.example.booking_az.mapper.CustomerMapper;
import com.example.booking_az.repository.CustomerRepository;
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

    @Override
    public CustomerResponseDto getById(Long id) {
        Customer getById = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found with this id"));
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
        Customer updatedCustomer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer not found with this id"));
        customerMapper.update(updatedCustomer, customerRequestDto);
        customerRepository.save(updatedCustomer);
        log.info("Booking updated with this id= " + id);
    }

    @Override
    public void delete(Long id) {
        Customer deletedCustomer = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found with this id"));
        customerRepository.delete(deletedCustomer);
        log.info("Booking deleted with this id= ",id);
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos = customerMapper.entityToCustomerResponseDto(customerList);
        return customerResponseDtos;
    }

    @Override
    public List<CustomerProjection> getNameByNationality(String nationality){
        return customerRepository.findByNationality(nationality);
    }
}
