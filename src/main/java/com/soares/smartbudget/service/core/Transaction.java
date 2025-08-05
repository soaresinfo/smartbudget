package com.soares.smartbudget.service.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record Transaction(UUID idTransaction,
                          BigDecimal value,
                          String description,
                          LocalDate transactionDate,
                          Expense expense) {
}
