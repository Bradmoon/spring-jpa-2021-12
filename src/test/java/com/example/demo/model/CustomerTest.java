package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void gettersAndSetters() {
        Customer customer = new Customer();
        customer.setFirstName("silly first name");
        customer.setLastName("silly last name");
        assertEquals("silly first name", customer.getFirstName());
        assertEquals("silly last name", customer.getLastName());
    }
}