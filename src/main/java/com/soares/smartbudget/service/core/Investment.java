package com.soares.smartbudget.service.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record Investment(
        UUID idInvestment,
        InvestmentType investmentType,
        Location location,
        BigDecimal balance,
        BigDecimal monthRevenue,
        LocalDate lastUpdateDate
) {
}