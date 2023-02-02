package com.griesba.bookingvtc.domain;

import java.util.Set;

public interface CustomerService {

    Customer save(Customer customer);

    Set<Customer> findAll();
}
