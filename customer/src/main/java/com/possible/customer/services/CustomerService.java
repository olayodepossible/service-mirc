package com.possible.customer.services;

import com.possible.customer.model.Customer;
import com.possible.customer.model.dto.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
    }
}
