package com.soares.smartbudget.service.core;

import java.util.UUID;

public record Location(
        UUID idLocation,
        String description
) {
}
