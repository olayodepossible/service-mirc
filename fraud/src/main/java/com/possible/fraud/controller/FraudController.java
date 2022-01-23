package com.possible.fraud.controller;

import com.possible.fraud.service.FraudHistoryCheckService;
import com.possible.fraud.model.dto.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudHistoryCheckService checkService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId")  Integer customerId){
        boolean isFraudulentCustomer = checkService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);

    }
}
