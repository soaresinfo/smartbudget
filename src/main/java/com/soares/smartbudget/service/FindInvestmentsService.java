package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.FindInvestmentsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FindInvestmentsService {

    private final FindInvestmentsGateway gateway;

    public List<Investment> findAllInvestmentsByMonth(LocalDate startDate, LocalDate endDate) {
        return gateway.findAllInvestmentsByMonth(startDate, endDate);
    }
}
