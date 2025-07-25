package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Investment;

import java.time.LocalDateTime;
import java.util.List;

public interface FindAllInvestmentsGateway {

    List<Investment> findAllInvestmentsByMonth(LocalDateTime startDate, LocalDateTime endDate);
}
