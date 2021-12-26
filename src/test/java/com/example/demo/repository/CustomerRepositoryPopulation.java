package com.example.demo.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRepositoryPopulation {


    private void populateRepo(CustomerRepository repository) {
//		repository.save(Customer.builder().firstName("Jack").lastName("Bauer").build().addPhone("home", "309.123.1234").addPhone("cell","309.321.4321"));
//		repository.save(Customer.builder().firstName("Chloe").lastName("O'Brian").build().addPhone("home", "409.123.1234").addPhone("cell","409.321.4321"));
//		repository.save(Customer.builder().firstName("Kim").lastName("Bauer").build().addPhone("home", "509.123.1234").addPhone("cell","509.321.4321"));
//		repository.save(Customer.builder().firstName("David").lastName("Palmer").build().addPhone("home", "609.123.1234").addPhone("cell","609.321.4321"));
//		repository.save(Customer.builder().firstName("Michelle").lastName("Dessler").build().addPhone("home", "709.123.1234").addPhone("cell","709.321.4321"));
    }

    @Bean
    public boolean loaded(CustomerRepository repository) {
        populateRepo(repository);
        return true;
    }

}