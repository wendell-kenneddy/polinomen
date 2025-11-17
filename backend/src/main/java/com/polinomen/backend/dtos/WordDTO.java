package com.polinomen.backend.dtos;

import java.time.Instant;
import java.util.List;

public record WordDTO(
    String id,
    String name,
    List<DefinitionDTO> definitions,
    List<PartOfSpeechDTO> partsOfSpeech,
    Instant createdAt,
    Instant updatedAt) {
}
