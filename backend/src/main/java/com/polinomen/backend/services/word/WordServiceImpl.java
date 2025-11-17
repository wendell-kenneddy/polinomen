package com.polinomen.backend.services.word;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polinomen.backend.dtos.ShortWordDTO;
import com.polinomen.backend.dtos.WordDTO;
import com.polinomen.backend.dtos.requests.CreateWordRequest;
import com.polinomen.backend.dtos.requests.UpdateWordRequest;
import com.polinomen.backend.mappers.IWordMapper;
import com.polinomen.backend.model.Definition;
import com.polinomen.backend.model.Dictionary;
import com.polinomen.backend.model.PartOfSpeech;
import com.polinomen.backend.model.Word;
import com.polinomen.backend.repositories.IWordRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class WordServiceImpl implements IWordService {
  private final IWordRepository wordRepository;
  private final IWordMapper wordMapper;

  public WordServiceImpl(
      IWordRepository wordRepository,
      IWordMapper wordMapper) {
    this.wordRepository = wordRepository;
    this.wordMapper = wordMapper;
  }

  public String createWord(String dictionaryId, CreateWordRequest request) {
    Dictionary dictionary = Dictionary
        .builder()
        .id(dictionaryId)
        .build();
    Word word = Word.builder()
        .dictionary(dictionary)
        .name(request.name())
        .build();
    word.setDefinitions(
        request.definitions()
            .stream()
            .map(d -> Definition.builder()
                .word(word)
                .description(d)
                .build())
            .toList());
    word.setPartsOfSpeech(
        request
            .partsOfSpeechIds()
            .stream()
            .map(p -> PartOfSpeech
                .builder()
                .id(p)
                .build())
            .toList());
    return this.wordRepository.save(word).getId();
  }

  public WordDTO getWord(String wordId) {
    Word word = this.wordRepository.findById(wordId)
        .orElseThrow(() -> new EntityNotFoundException("Word not found."));
    return this.wordMapper.entityToDTO(word);
  }

  public List<ShortWordDTO> getAllWords(String dictionaryId) {
    return this.wordRepository
        .findAllByDictionaryId(dictionaryId)
        .stream()
        .map(this.wordMapper::entityToShortDTO)
        .toList();
  }

  @Transactional
  public void updateWord(
      String wordId,
      UpdateWordRequest request) {
    this.wordRepository.updateWordNameById(wordId, request.name());
  }

  @Transactional
  public void deleteWord(String wordId) {
    this.wordRepository.deleteById(wordId);
  }
}
