package com.possible.fraud.controller;

import com.possible.fraud.service.FraudHistoryCheckService;
import com.possible.fraud.model.dto.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudHistoryCheckService checkService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId){
        boolean isFraudulentCustomer = checkService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);

    }
}
