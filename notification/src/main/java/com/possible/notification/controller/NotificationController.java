package com.possible.notification.controller;

import com.possible.clients.fraud.dto.FraudCheckResponse;
import com.possible.clients.notification.dto.NotificationResponse;
import com.possible.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationservice;

    @PostMapping
    public NotificationResponse fraudCheckResponse(@RequestBody FraudCheckResponse response){
        log.info("REQ: {}", response);
       return notificationservice.sendFraudResponse(response);
    }
}
