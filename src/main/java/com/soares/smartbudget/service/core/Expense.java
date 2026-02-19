package com.soares.smartbudget.service.core;

import java.math.BigDecimal;

public record Expense(Long idCategory,
                      BigDecimal plannedValue,
                      String description,
                      Category category) {
}
