package com.soares.smartbudget.service.core;

import java.util.UUID;

public record IncomeCategory(
        UUID idIncomeCategory,
        String description
) {
}