package com.example.demo.repository;

import com.example.demo.SpringJpaApplication;
import com.example.demo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringJpaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@ContextConfiguration(classes = { CustomerRepositoryPopulation.class })
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;

    @BeforeEach
    public void setUp() throws Exception {
//		repository.save(new Customer("Jack", "Bauer"));
//		repository.save(new Customer("Chloe", "O'Brian"));
//		repository.save(new Customer("Kim", "Bauer"));
//		repository.save(new Customer("David", "Palmer"));
//		repository.save(new Customer("Michelle", "Dessler"));
    }

    @Test
    public void findAllCustomers() {
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        Iterable<Customer> findAll = repository.findAll();
        for (Customer customer : findAll) {
            log.info(String.format("EYECATCHER: %s", customer.toString()));
        }
        List<Customer> custs = (List<Customer>) findAll;
        assertEquals(5, custs.size());

    }

    @Test
    public void findBauers() {
        List<Customer> bauers = repository.findByLastName("Bauer");
        assertEquals(2, bauers.size());
        Customer customer = bauers.get(0);
        int count = customer.getPhones().size();
        assertEquals(2, count);
    }

}