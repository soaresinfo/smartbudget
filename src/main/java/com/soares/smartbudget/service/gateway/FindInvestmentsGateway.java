package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Investment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FindInvestmentsGateway {

    List<Investment> findAllInvestmentsByMonth(LocalDate startDate, LocalDate endDate);

    Optional<Investment> findInvestmentByPortfolioAndPreviousMonth(String idPortfolio, LocalDate searchDate);
}
