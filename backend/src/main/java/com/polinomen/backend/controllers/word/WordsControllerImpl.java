package com.polinomen.backend.controllers.word;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polinomen.backend.dtos.ShortWordDTO;
import com.polinomen.backend.dtos.WordDTO;
import com.polinomen.backend.dtos.requests.CreateWordRequest;
import com.polinomen.backend.dtos.requests.UpdateWordRequest;
import com.polinomen.backend.services.word.IWordService;

@RestController
public class WordsControllerImpl {
  private final IWordService wordService;

  public WordsControllerImpl(IWordService wordService) {
    this.wordService = wordService;
  }

  @PostMapping("/dictionaries/{dictionaryId}/words")
  public String createWord(
      @PathVariable String dictionaryId,
      @RequestBody CreateWordRequest request) {
    return this.wordService.createWord(dictionaryId, request);
  }

  @GetMapping("/dictionaries/{dictionaryId}/words/{wordId}")
  public WordDTO get(@PathVariable String wordId) {
    return this.wordService.getWord(wordId);
  }

  @GetMapping("/dictionaries/{dictionaryId}/words")
  public List<ShortWordDTO> getAllWords(@PathVariable String dictionaryId) {
    return this.wordService.getAllWords(dictionaryId);
  }

  @PutMapping("/dictionaries/{dictionaryId}/words/{wordId}")
  public void updateWord(@PathVariable String wordId, @RequestBody UpdateWordRequest request) {
    this.wordService.updateWord(wordId, request);
  }

  @DeleteMapping("/dictionaries/{dictionaryId}/words/{wordId}")
  public void deleteWord(@PathVariable String wordId) {
    this.wordService.deleteWord(wordId);
  }
}
