package com.soares.smartbudget.controller.model;

import java.util.UUID;

public record IncomeCategoryResponseModel(
        UUID idIncomeCategory,
        String description
) {
}