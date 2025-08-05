package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Investment;

import java.time.LocalDate;
import java.util.List;

public interface FindInvestmentsGateway {

    List<Investment> findAllInvestmentsByMonth(LocalDate startDate, LocalDate endDate);
}
