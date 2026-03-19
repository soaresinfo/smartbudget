package com.soares.smartbudget.service.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Investment(
        Long idInvestment,
        String idPortfolio,
        InvestmentType investmentType,
        Location location,
        BigDecimal balance,
        BigDecimal monthRevenue,
        BigDecimal contribution,
        BigDecimal withdraw,
        LocalDate lastUpdateDate
) {
}