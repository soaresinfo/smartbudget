package com.soares.smartbudget.service.core;

import java.util.UUID;

public record InvestmentType(
        UUID idInvestmentType,
        String description
) {
}
