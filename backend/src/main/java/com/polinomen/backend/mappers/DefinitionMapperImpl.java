package com.polinomen.backend.mappers;

import org.springframework.stereotype.Component;

import com.polinomen.backend.dtos.DefinitionDTO;
import com.polinomen.backend.model.Definition;

@Component
public class DefinitionMapperImpl implements IDefinitionMapper {

  @Override
  public DefinitionDTO entityToDTO(Definition entity) {
    return new DefinitionDTO(
        entity.getId(),
        entity.getDescription(),
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }

  @Override
  public Definition DTOToEntity(DefinitionDTO DTO) {
    return Definition.builder()
        .id(DTO.id())
        .description(DTO.description()).build();
  }
}
