package com.polinomen.backend.controllers.dictionary;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.polinomen.backend.dtos.DictionaryDTO;
import com.polinomen.backend.dtos.requests.CreateDictionaryRequest;
import com.polinomen.backend.dtos.requests.UpdateDictionaryRequest;

public interface IDictionaryController {
  public String create(Authentication authentication, CreateDictionaryRequest request);

  public DictionaryDTO get(String dictionaryId);

  public List<DictionaryDTO> getAll(Authentication authentication);

  public void update(String dictionaryId,
      UpdateDictionaryRequest request);

  public void delete(String dictionaryId);
}
