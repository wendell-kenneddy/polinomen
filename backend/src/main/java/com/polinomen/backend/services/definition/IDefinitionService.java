package com.polinomen.backend.services.definition;

import java.util.List;

import com.polinomen.backend.dtos.DefinitionDTO;
import com.polinomen.backend.dtos.requests.CreateDefinitionRequest;
import com.polinomen.backend.dtos.requests.UpdateDefinitionRequest;

public interface IDefinitionService {
  public String createDefinition(String wordId, CreateDefinitionRequest request);

  public List<DefinitionDTO> getAllDefinitions(String wordId);

  public void updateDefinition(String definitionId, UpdateDefinitionRequest request);

  public void deleteDefinition(String definitionId);
}
