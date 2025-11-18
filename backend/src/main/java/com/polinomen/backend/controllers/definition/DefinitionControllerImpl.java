package com.polinomen.backend.controllers.definition;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polinomen.backend.dtos.DefinitionDTO;
import com.polinomen.backend.dtos.requests.CreateDefinitionRequest;
import com.polinomen.backend.dtos.requests.UpdateDefinitionRequest;
import com.polinomen.backend.services.definition.IDefinitionService;

@RestController
public class DefinitionControllerImpl implements IDefinitionController {
  private final IDefinitionService definitionsService;

  public DefinitionControllerImpl(IDefinitionService definitionsService) {
    this.definitionsService = definitionsService;
  }

  @PostMapping("/dictionaries/{dictionaryId}/words/{wordId}/definitions")
  public String createDefinition(@PathVariable String wordId, @RequestBody CreateDefinitionRequest request) {
    return this.definitionsService.createDefinition(wordId, request);
  }

  @GetMapping("/dictionaries/{dictionaryId}/words/{wordId}/definitions")
  public List<DefinitionDTO> getAllDefinitions(@PathVariable String wordId) {
    return this.definitionsService.getAllDefinitions(wordId);
  }

  @PutMapping("/dictionaries/{dictionaryId}/words/{wordId}/definitions/{definitionId}")
  public void updateDefinition(@PathVariable String definitionId, @RequestBody UpdateDefinitionRequest request) {
    this.definitionsService.updateDefinition(definitionId, request);
  }

  @DeleteMapping("/dictionaries/{dictionaryId}/words/{wordId}/definitions/{definitionId}")
  public void deleteDefinition(@PathVariable String definitionId) {
    this.definitionsService.deleteDefinition(definitionId);
  }
}
