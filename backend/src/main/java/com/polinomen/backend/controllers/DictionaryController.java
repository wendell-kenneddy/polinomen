package com.polinomen.backend.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polinomen.backend.dtos.DictionaryDTO;
import com.polinomen.backend.dtos.requests.CreateDictionaryRequest;
import com.polinomen.backend.dtos.requests.UpdateDictionaryRequest;
import com.polinomen.backend.services.dictionary.IDictionaryService;

@RestController
public class DictionaryController {
  private IDictionaryService dictionaryService;

  public DictionaryController(IDictionaryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  @PostMapping("/dictionaries")
  public String create(Authentication authentication, @RequestBody CreateDictionaryRequest request) {
    return this.dictionaryService.createDictionary(authentication, request);
  }

  @GetMapping("/dictionaries/{dictionaryId}")
  public DictionaryDTO get(@PathVariable String dictionaryId) {
    return this.dictionaryService.getDictionary(dictionaryId);
  }

  @GetMapping("/dictionaries")
  public List<DictionaryDTO> getAll(Authentication authentication) {
    return this.dictionaryService.getAllDictionaries(authentication);
  }

  @PutMapping("/dictionaries/{dictionaryId}")
  public void update(@PathVariable String dictionaryId,
      @RequestBody UpdateDictionaryRequest request) {
    this.dictionaryService.updateDictionary(dictionaryId, request);
  }

  @DeleteMapping("/dictionaries/{dictionaryId}")
  public void delete(@PathVariable String dictionaryId) {
    this.dictionaryService.deleteDictionary(dictionaryId);
  }

}
