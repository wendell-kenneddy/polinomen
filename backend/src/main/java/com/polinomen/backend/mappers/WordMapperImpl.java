package com.polinomen.backend.mappers;

import org.springframework.stereotype.Component;

import com.polinomen.backend.dtos.DefinitionDTO;
import com.polinomen.backend.dtos.PartOfSpeechDTO;
import com.polinomen.backend.dtos.ShortWordDTO;
import com.polinomen.backend.dtos.WordDTO;
import com.polinomen.backend.model.Definition;
import com.polinomen.backend.model.PartOfSpeech;
import com.polinomen.backend.model.Word;

@Component
public class WordMapperImpl implements IWordMapper {
  private IMapper<Definition, DefinitionDTO> definitionMapper;
  private IMapper<PartOfSpeech, PartOfSpeechDTO> partOfSpeechMapper;

  public WordMapperImpl(
      IMapper<Definition, DefinitionDTO> definitionMapper,
      IMapper<PartOfSpeech, PartOfSpeechDTO> partOfSpeechMapper) {
    this.definitionMapper = definitionMapper;
    this.partOfSpeechMapper = partOfSpeechMapper;
  }

  @Override
  public WordDTO entityToDTO(Word entity) {
    return new WordDTO(
        entity.getId(),
        entity.getName(),
        entity.getDefintions().stream().map(this.definitionMapper::entityToDTO).toList(),
        entity.getPartsOfSpeech().stream().map(this.partOfSpeechMapper::entityToDTO).toList(),
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }

  @Override
  public Word DTOToEntity(WordDTO DTO) {
    return Word.builder()
        .id(DTO.id())
        .name(DTO.name())
        .defintions(DTO.definitions().stream().map(d -> this.definitionMapper.DTOToEntity(d)).toList())
        .partsOfSpeech(DTO.partsOfSpeech().stream().map(d -> this.partOfSpeechMapper.DTOToEntity(d)).toList())
        .createdAt(DTO.createdAt())
        .updatedAt(DTO.updatedAt())
        .build();
  }

  @Override
  public ShortWordDTO entityToShortDTO(Word entity) {
    return new ShortWordDTO(entity.getId(), entity.getName(), entity.getCreatedAt(), entity.getUpdatedAt());
  }
}
