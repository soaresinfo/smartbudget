package com.soares.smartbudget.service.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction(Long idTransaction,
                          BigDecimal value,
                          String description,
                          LocalDate transactionDate,
                          Category category,
                          Integer installmentNumber,
                          Integer installmentTotal) {
}
