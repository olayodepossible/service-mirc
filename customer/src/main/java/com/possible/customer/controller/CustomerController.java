package com.possible.customer.controller;

import com.possible.clients.notification.dto.NotificationResponse;
import com.possible.customer.model.Customer;
import com.possible.customer.model.dto.CustomerRegistrationRequest;
import com.possible.customer.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        return new ResponseEntity<>(customerService.registerCustomer(customerRegistrationRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fraud-check/{customerId}")
    public ResponseEntity<NotificationResponse>  customerFraudCheck(@PathVariable("customerId") Integer customerId){
       return new ResponseEntity<>( customerService.fraudNotification(customerId), HttpStatus.OK);
    }
}
