package com.possible.fraud.repository;

import com.possible.fraud.model.FraudHistoryCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudHistoryCheckRepository extends JpaRepository<FraudHistoryCheck, Integer> {
}
