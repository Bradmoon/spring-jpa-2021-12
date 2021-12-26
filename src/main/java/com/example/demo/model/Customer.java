package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUST_ID")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Phone> phones = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer addPhone(String type, String number) {
        Phone phone = Phone.builder().type(type).number(number).build();
        this.phones.add(phone);
        return this;
    }
    public Customer addPhone(Phone phone) {
        this.phones.add(phone);
        return this;
    }
}
