package com.polinomen.backend.services.word;

import java.util.List;

import com.polinomen.backend.dtos.ShortWordDTO;
import com.polinomen.backend.dtos.WordDTO;
import com.polinomen.backend.dtos.requests.CreateWordRequest;
import com.polinomen.backend.dtos.requests.UpdateWordRequest;

public interface IWordService {
  public String createWord(String dictionaryId, CreateWordRequest request);

  public WordDTO getWord(String wordId);

  public List<ShortWordDTO> getAllWords(String dictionaryId);

  public void updateWord(String wordId, UpdateWordRequest request);

  public void deleteWord(String wordId);
}
