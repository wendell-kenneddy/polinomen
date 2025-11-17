package com.polinomen.backend.services.definition;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polinomen.backend.dtos.DefinitionDTO;
import com.polinomen.backend.dtos.requests.CreateDefinitionRequest;
import com.polinomen.backend.dtos.requests.UpdateDefinitionRequest;
import com.polinomen.backend.mappers.IDefinitionMapper;
import com.polinomen.backend.model.Definition;
import com.polinomen.backend.model.Word;
import com.polinomen.backend.repositories.IDefinitionRepository;

import jakarta.transaction.Transactional;

@Service
public class DefinitionsServiceImpl implements IDefinitionService {
  private final IDefinitionRepository definitionRepository;
  private final IDefinitionMapper definitionMapper;

  public DefinitionsServiceImpl(
      IDefinitionRepository definitionRepository,
      IDefinitionMapper definitionMapper) {
    this.definitionRepository = definitionRepository;
    this.definitionMapper = definitionMapper;
  }

  public String createDefinition(String wordId, CreateDefinitionRequest request) {
    Word word = Word.builder().id(wordId).build();
    Definition definition = Definition.builder().word(word).description(request.description()).build();
    return this.definitionRepository.save(definition).getId();
  }

  public List<DefinitionDTO> getAllDefinitions(String wordId) {
    return this.definitionRepository
        .findAllByWordId(wordId)
        .stream()
        .map(this.definitionMapper::entityToDTO)
        .toList();
  }

  @Transactional
  public void updateDefinition(String definitionId, UpdateDefinitionRequest request) {
    this.definitionRepository.updateDefinitionById(definitionId, request.description());
  }

  @Transactional
  public void deleteDefinition(String definitionId) {
    this.definitionRepository.deleteById(definitionId);
  }
}
