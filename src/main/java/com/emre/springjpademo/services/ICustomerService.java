package com.emre.springjpademo.services;

import com.emre.springjpademo.dtos.CustomerDto;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> findAll();
    CustomerDto findById(long id);
    CustomerDto save(CustomerDto customerDto);
    void deleteById(long id);
    CustomerDto updateCustomer(long id, CustomerDto customerDto);
}
