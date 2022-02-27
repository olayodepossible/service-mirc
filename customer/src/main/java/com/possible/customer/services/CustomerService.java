package com.possible.customer.services;

import com.possible.clients.fraud.FraudClient;
import com.possible.clients.fraud.dto.FraudCheckResponse;
import com.possible.clients.notification.NotificationClient;
import com.possible.clients.notification.dto.NotificationResponse;
import com.possible.customer.CustomerRepository;
import com.possible.customer.model.Customer;
import com.possible.customer.model.dto.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient) {

    public Customer registerCustomer(CustomerRegistrationRequest request) {
        //TODO call third-party API
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        System.out.println();
       return customerRepository.save(customer);


    }

    public NotificationResponse fraudNotification(Integer customerId){
        NotificationResponse response = fraudClient.isFraudster(customerId);  //TODO CHECK EXT APIker
        Customer customer = customerRepository.getById(response.getCustomerId());
        String userName = customer.getLastName() +" "+ customer.getFirstName();
        if (Boolean.TRUE.equals(response.isFraudster())){
            return NotificationResponse.builder()
                    .customerId(customer.getId())
                    .message(userName+" is a fraudster")
                    .isFraudster(true)
                    .build();
        }

        return NotificationResponse.builder()
                .customerId(customer.getId())
                .message(userName+" pass fraud check")
                .isFraudster(false)
                .build();
    }
}
