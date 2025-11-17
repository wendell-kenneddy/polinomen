package com.polinomen.backend.mappers;

import org.springframework.stereotype.Component;

import com.polinomen.backend.dtos.DictionaryDTO;
import com.polinomen.backend.model.Dictionary;

@Component
public class DictionaryMapperImpl implements IDictionaryMapper {

  @Override
  public DictionaryDTO entityToDTO(Dictionary entity) {
    return new DictionaryDTO(
        entity.getId(),
        entity.getName(),
        entity.getDescription(),
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }

  @Override
  public Dictionary DTOToEntity(DictionaryDTO DTO) {
    return Dictionary.builder()
        .id(DTO.id())
        .name(DTO.name())
        .description(DTO.description())
        .createdAt(DTO.createdAt())
        .updatedAt(DTO.updatedAt())
        .build();
  }
}
