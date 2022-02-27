package com.possible.fraud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.possible.clients.fraud.dto.FraudCheckResponse;
import com.possible.clients.notification.NotificationClient;
import com.possible.clients.notification.dto.NotificationResponse;
import com.possible.fraud.model.FraudHistoryCheck;
import com.possible.fraud.repository.FraudHistoryCheckRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class FraudHistoryCheckService {
    private final FraudHistoryCheckRepository repo;
    private final NotificationClient notificationClient;

    public NotificationResponse isFraudulentCustomer(Integer customerId) throws IOException {
       FraudHistoryCheck checkData = repo.save(
                FraudHistoryCheck.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
// todo call third party api

        FraudCheckResponse fraudCheckResponse = FraudCheckResponse.builder()
                .customerId(checkData.getCustomerId())
                .isFraudster(checkData.getIsFraudster())
                .createdAt(checkData.getCreatedAt())
                .build();

       return notificationClient.fraudCheckResponse(fraudCheckResponse);
    }



}
