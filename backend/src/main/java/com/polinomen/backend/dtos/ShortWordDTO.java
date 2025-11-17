package com.polinomen.backend.dtos;

import java.time.Instant;

public record ShortWordDTO(
    String id,
    String name,
    Instant createdAt,
    Instant updatedAt) {
}
