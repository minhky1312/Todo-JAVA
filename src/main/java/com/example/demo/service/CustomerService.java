package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getCustomer();


    void saveCustomer(Customer customer);

    void deleteCustomer(Long id);


    Optional<Customer> FindCustomerByid (Long id);

}
