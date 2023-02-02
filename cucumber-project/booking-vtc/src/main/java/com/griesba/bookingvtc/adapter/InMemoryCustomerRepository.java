package com.griesba.bookingvtc.adapter;

import com.griesba.bookingvtc.domain.Customer;
import com.griesba.bookingvtc.domain.repository.CustomerRepository;

import java.util.LinkedHashSet;
import java.util.Set;

public class InMemoryCustomerRepository implements CustomerRepository {

    Set<Customer> customers = new LinkedHashSet<>();

    @Override
    public Customer add(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public Set<Customer> all() {
        return customers;
    }
}
