package com.polinomen.backend.services.part_of_speech;

import java.util.List;

import com.polinomen.backend.dtos.PartOfSpeechDTO;
import com.polinomen.backend.dtos.requests.AddPartOfSpeechToWordRequest;

public interface IPartOfSpeechService {
  public List<PartOfSpeechDTO> getAllPartsOfSpeech();

  public void addExistingPartOfSpeechToWord(String wordId, AddPartOfSpeechToWordRequest request);

  public void removePartOfSpeechFromWord(String wordId, String partOfSpeechId);
}
