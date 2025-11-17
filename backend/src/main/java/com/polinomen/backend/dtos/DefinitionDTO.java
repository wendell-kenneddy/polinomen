package com.polinomen.backend.dtos;

import java.time.Instant;

public record DefinitionDTO(
    String id,
    String description,
    Instant createdAt,
    Instant updatedAt) {
}
