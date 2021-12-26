package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Transactional (propagation=Propagation.REQUIRED)
    public Customer findById(Long id) {
        Optional<Customer> cust = repository.findById(id);
        Customer customer = cust.get();
        customer.getPhones();
        return customer;
    }


    @Transactional (propagation=Propagation.REQUIRED )
    public Iterable<Customer> findAllCustomers() {
        Iterable<Customer> customers = repository.findAll();
        return customers;
    }

}