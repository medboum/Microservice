package com.microservice;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckHistoryService {
    public final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository){
        this.fraudCheckHistoryRepository=fraudCheckHistoryRepository;
    }

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAl(LocalDateTime.now())
                        .build()
        );
return false;
    }
}
