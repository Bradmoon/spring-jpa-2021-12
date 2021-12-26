package com.example.demo.service;

import com.example.demo.SpringJpaApplication;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepositoryPopulation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringJpaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes= {CustomerRepositoryPopulation.class})
public class CustomerServiceTest {
    @Autowired
    private CustomerService service;

    @Test
    public void findById() {
        Customer customer = service.findById(1L);
        int size = customer.getPhones().size();
        assertEquals(2, size);
        assertEquals("Customer(id=1, firstName=Jack, lastName=Bauer, phones=[Phone(id=2, type=home, number=309.123.1234), Phone(id=3, type=cell, number=309.321.4321)])", customer.toString());
    }

    @Test
    public void findAll() {
        Iterable<Customer> customers = service.findAllCustomers();
        assertEquals(customers.spliterator().getExactSizeIfKnown(), 5);
        for (Customer customer : customers) {
            log.info(customer.toString());
        }
    }

}