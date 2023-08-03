package com.soares.smartbudget.service.core;

import java.math.BigDecimal;
import java.util.UUID;

public record Expense(UUID idExpense,
                      BigDecimal plannedValue,
                      String description) {
}
