package com.possible.notification.service;

import com.possible.clients.fraud.dto.FraudCheckResponse;
import com.possible.clients.notification.dto.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    public NotificationResponse sendFraudResponse(FraudCheckResponse response) {
        if (Boolean.TRUE.equals(response.getIsFraudster())) return NotificationResponse.builder()
                .customerId(response.getCustomerId())
                .isFraudster(true)
                .build();

        return NotificationResponse.builder()
                .customerId(response.getCustomerId())
                .isFraudster(false)
                .build();
    }


}
