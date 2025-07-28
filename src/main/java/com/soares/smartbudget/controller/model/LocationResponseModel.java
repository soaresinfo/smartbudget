package com.soares.smartbudget.controller.model;

import java.util.UUID;

public record LocationResponseModel(
        UUID idLocation,
        String description
) {
}