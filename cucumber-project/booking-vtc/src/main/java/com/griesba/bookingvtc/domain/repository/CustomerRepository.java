package com.griesba.bookingvtc.domain.repository;

import com.griesba.bookingvtc.domain.Customer;

import java.util.Set;


public interface CustomerRepository {
    Customer add(Customer customer);

    Set<Customer> all();
}
