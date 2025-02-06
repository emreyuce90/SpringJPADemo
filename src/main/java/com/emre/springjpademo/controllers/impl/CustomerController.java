package com.emre.springjpademo.controllers.impl;

import com.emre.springjpademo.controllers.ICustomerController;
import com.emre.springjpademo.dtos.CustomerDto;
import com.emre.springjpademo.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController implements ICustomerController {

    @Autowired
    private ICustomerService customerService;


   @GetMapping("")
    @Override
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

    @GetMapping("{id}")
    @Override
    public CustomerDto findById(@PathVariable(name = "id") long id) {
        return customerService.findById(id);
    }
}
