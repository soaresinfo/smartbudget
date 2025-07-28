package com.soares.smartbudget.service.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record Income(
        UUID idIncome,
        BigDecimal value,
        String description,
        LocalDate incomeDate,
        IncomeCategory incomeCategory
) {
}