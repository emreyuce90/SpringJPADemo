package com.emre.springjpademo.services.impl;

import com.emre.springjpademo.dtos.AddressDto;
import com.emre.springjpademo.dtos.CustomerDto;
import com.emre.springjpademo.entities.Address;
import com.emre.springjpademo.entities.Customer;
import com.emre.springjpademo.repositories.ICustomerRepository;
import com.emre.springjpademo.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<CustomerDto> findAll() {
       List<Customer> allCustomers =  customerRepository.findAll();

       List<CustomerDto> customerDtos = new ArrayList<>();

       for (Customer customer : allCustomers) {
           CustomerDto customerDto = new CustomerDto();
           customerDto.setId(customer.getId());
           customerDto.setName(customer.getName());
           customerDto.setAddressDto(new AddressDto(customer.getAddress().getId(),customer.getAddress().getName(),
                   customer.getAddress().getDescription()));
           customerDtos.add(customerDto);
       }
       return customerDtos;
    }

    @Override
    public CustomerDto findById(long id) {
        Optional<Customer> optional =  customerRepository.findById(id);
        if (optional.isPresent()) {
            Customer customer = optional.get();
            Address address = customer.getAddress();

            CustomerDto customerDto = new CustomerDto();
            AddressDto addressDto = new AddressDto();

            BeanUtils.copyProperties(customer, customerDto);
            BeanUtils.copyProperties(address, addressDto);
            customerDto.setAddressDto(addressDto);
            return customerDto;
        }
        return null;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public CustomerDto updateCustomer(long id, CustomerDto customerDto) {
        return null;
    }
}
