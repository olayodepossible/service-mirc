package com.possible.clients.customer;

import com.possible.clients.fraud.dto.FraudCheckResponse;
import com.possible.clients.notification.dto.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "customer", path = "localhost:8081/")
public interface CustomerClient {

    @GetMapping
    NotificationResponse customerFraudCheck(@RequestBody FraudCheckResponse response);
}
