package com.polinomen.backend.mappers;

import org.springframework.stereotype.Component;

import com.polinomen.backend.dtos.PartOfSpeechDTO;
import com.polinomen.backend.model.PartOfSpeech;

@Component
public class PartOfSpeechMapperImpl implements IPartOfSpeechMapper {
  @Override
  public PartOfSpeechDTO entityToDTO(PartOfSpeech entity) {
    return new PartOfSpeechDTO(
        entity.getId(),
        entity.getName(),
        entity.getDescription(),
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }

  @Override
  public PartOfSpeech DTOToEntity(PartOfSpeechDTO DTO) {
    return PartOfSpeech.builder()
        .id(DTO.id())
        .name(DTO.name())
        .description(DTO.description())
        .createdAt(DTO.createdAt())
        .updatedAt(DTO.updatedAt())
        .build();
  }
}
