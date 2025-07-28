package com.soares.smartbudget.controller.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record InvestmentResponseModel(
        UUID idInvestment,
        InvestmentTypeResponseModel investmentType,
        LocationResponseModel location,
        BigDecimal balance,
        BigDecimal monthRevenue,
        LocalDate lastUpdateDate
) {
}