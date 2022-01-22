package com.possible.fraud.service;

import com.possible.fraud.model.FraudHistoryCheck;
import com.possible.fraud.repository.FraudHistoryCheckRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudHistoryCheckService {
    private final FraudHistoryCheckRepository repo;


    public boolean isFraudulentCustomer(Integer customerId){
        repo.save(
                FraudHistoryCheck.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
// todo
        return false;
    }
}
