package com.soares.smartbudget.controller.model;

import java.util.UUID;

public record InvestmentTypeResponseModel(
        UUID idInvestmentType,
        String description
) {
}