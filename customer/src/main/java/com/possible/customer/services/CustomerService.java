package com.possible.customer.services;

import com.possible.clients.fraud.FraudClient;
import com.possible.clients.fraud.dto.FraudCheckResponse;
import com.possible.customer.CustomerRepository;
import com.possible.customer.model.Customer;
import com.possible.customer.model.dto.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        log.info("RESPONSE FROM FRAUD-SERVICE: {}", fraudCheckResponse);
    }
}
