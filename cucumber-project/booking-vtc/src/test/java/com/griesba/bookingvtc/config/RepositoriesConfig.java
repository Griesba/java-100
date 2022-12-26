package com.griesba.bookingvtc.config;

import com.griesba.bookingvtc.adapter.InMemoryCustomerRepository;
import com.griesba.bookingvtc.domain.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoriesConfig {

    @Bean
    @Scope("cucumber-glue")
    public CustomerRepository customerRepository() {
        return new InMemoryCustomerRepository();
    }
}
