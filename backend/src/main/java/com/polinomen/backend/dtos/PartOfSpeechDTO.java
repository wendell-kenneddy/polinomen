package com.polinomen.backend.dtos;

import java.time.Instant;

public record PartOfSpeechDTO(
    String id,
    String name,
    String description,
    Instant createdAt,
    Instant updatedAt) {
}
