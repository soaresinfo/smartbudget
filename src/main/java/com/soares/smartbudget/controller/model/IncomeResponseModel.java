package com.soares.smartbudget.controller.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record IncomeResponseModel(
        UUID idIncome,
        BigDecimal value,
        String description,
        LocalDate incomeDate,
        IncomeCategoryResponseModel incomeCategory
) {
}