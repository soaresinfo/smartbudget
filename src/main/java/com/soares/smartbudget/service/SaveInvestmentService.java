package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.SaveInvestmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveInvestmentService {

    private final SaveInvestmentGateway gateway;

    public Investment save(Investment investment) {
        return gateway.save(investment);
    }
}
