package com.polinomen.backend.services.dictionary;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.polinomen.backend.dtos.DictionaryDTO;
import com.polinomen.backend.dtos.requests.CreateDictionaryRequest;
import com.polinomen.backend.dtos.requests.UpdateDictionaryRequest;
import com.polinomen.backend.mappers.IDictionaryMapper;
import com.polinomen.backend.model.Dictionary;
import com.polinomen.backend.model.User;
import com.polinomen.backend.repositories.IDictionaryRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
  private IDictionaryRepository dictionaryRepository;
  private IDictionaryMapper dictionaryMapper;

  public DictionaryServiceImpl(
      IDictionaryRepository dictionaryRepository,
      IDictionaryMapper dictionaryMapper) {
    this.dictionaryRepository = dictionaryRepository;
    this.dictionaryMapper = dictionaryMapper;
  }

  public String createDictionary(Authentication authentication, CreateDictionaryRequest request) {
    User user = User.builder().id(authentication.getName()).build();
    Dictionary dictionary = Dictionary.builder()
        .name(request.name())
        .description(request.description())
        .user(user)
        .build();
    return this.dictionaryRepository.save(dictionary).getId();
  }

  public DictionaryDTO getDictionary(String dictionaryId) {
    Dictionary dictionary = this.dictionaryRepository
        .findById(dictionaryId)
        .orElseThrow(() -> new EntityNotFoundException("Dictionary not found."));
    return this.dictionaryMapper.entityToDTO(dictionary.setWords(List.of()));
  }

  public List<DictionaryDTO> getAllDictionaries(Authentication authentication) {
    return this.dictionaryRepository
        .findAllByUserId(authentication.getName())
        .stream()
        .map(this.dictionaryMapper::entityToDTO)
        .toList();
  }

  @Transactional
  public void updateDictionary(String dictionaryId, UpdateDictionaryRequest request) {
    this.dictionaryRepository.updateById(dictionaryId, request.name(), request.description());
  }

  @Transactional
  public void deleteDictionary(String dictionaryId) {
    this.dictionaryRepository.deleteById(dictionaryId);
  }

}
