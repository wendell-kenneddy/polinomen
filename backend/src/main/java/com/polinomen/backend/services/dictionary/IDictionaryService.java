package com.polinomen.backend.services.dictionary;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.polinomen.backend.dtos.DictionaryDTO;
import com.polinomen.backend.dtos.requests.CreateDictionaryRequest;
import com.polinomen.backend.dtos.requests.UpdateDictionaryRequest;

public interface IDictionaryService {
  public String createDictionary(Authentication authentication, CreateDictionaryRequest request);

  public DictionaryDTO getDictionary(String dictionaryId);

  public List<DictionaryDTO> getAllDictionaries(Authentication authentication);

  public void updateDictionary(String dictionaryId, UpdateDictionaryRequest request);

  public void deleteDictionary(String dictionaryId);
}
