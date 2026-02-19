package com.soares.smartbudget.service.core;

import java.math.BigDecimal;

public record Category(Long idCategory,
                       BigDecimal plannedValue,
                       String description,
                       Category parent) {
}
