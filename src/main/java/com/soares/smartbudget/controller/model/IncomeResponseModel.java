package com.soares.smartbudget.controller.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record IncomeResponseModel(
        Long idIncome,
        BigDecimal value,
        String description,
        LocalDate incomeDate,
        IncomeCategoryResponseModel incomeCategory
) {
}