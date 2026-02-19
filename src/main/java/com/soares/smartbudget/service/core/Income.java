package com.soares.smartbudget.service.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Income(
        Long idIncome,
        BigDecimal value,
        String description,
        LocalDate incomeDate,
        IncomeCategory incomeCategory
) {
}