package com.possible.fraud.controller;

import com.possible.clients.notification.dto.NotificationResponse;
import com.possible.fraud.service.FraudHistoryCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudHistoryCheckService checkService;

    @GetMapping(value = "{customerId}")
    public NotificationResponse isFraudster(@PathVariable("customerId")  Integer customerId) throws IOException {
        return checkService.isFraudulentCustomer(customerId);
    }
}
