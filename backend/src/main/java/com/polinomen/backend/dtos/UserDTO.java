package com.polinomen.backend.dtos;

import java.time.Instant;

public record UserDTO(
    String username,
    String email,
    Instant createdAt,
    Instant updatedAt) {
}
