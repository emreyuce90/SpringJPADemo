package com.emre.springjpademo.controllers;

import com.emre.springjpademo.dtos.CustomerDto;

import java.util.List;

public interface ICustomerController {
    List<CustomerDto> findAll();
    CustomerDto findById(long id);
}
