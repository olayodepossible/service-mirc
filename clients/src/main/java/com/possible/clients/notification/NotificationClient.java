package com.possible.clients.notification;

import com.possible.clients.fraud.dto.FraudCheckResponse;
import com.possible.clients.notification.dto.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification", path = "api/v1/notifications")
public interface NotificationClient {

    @PostMapping
    NotificationResponse fraudCheckResponse( @RequestBody FraudCheckResponse response);
}
