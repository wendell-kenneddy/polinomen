package com.polinomen.backend.controllers.word;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.polinomen.backend.dtos.ShortWordDTO;
import com.polinomen.backend.dtos.WordDTO;
import com.polinomen.backend.dtos.requests.CreateWordRequest;
import com.polinomen.backend.dtos.requests.UpdateWordRequest;

public interface IWordController {
  public String createWord(
      Authentication authentication,
      String dictionaryId,
      CreateWordRequest request);

  public WordDTO get(String wordId);

  public List<ShortWordDTO> getAllWords(String dictionaryId);

  public void updateWord(String wordId, UpdateWordRequest request);

  public void deleteWord(String wordId);
}
