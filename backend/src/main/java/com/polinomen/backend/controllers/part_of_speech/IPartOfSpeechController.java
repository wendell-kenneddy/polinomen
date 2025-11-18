package com.polinomen.backend.controllers.part_of_speech;

import java.util.List;

import com.polinomen.backend.dtos.PartOfSpeechDTO;
import com.polinomen.backend.dtos.requests.AddPartOfSpeechToWordRequest;

public interface IPartOfSpeechController {
  public void addExistingPartOfSpeechToWord(
      String wordId,
      AddPartOfSpeechToWordRequest request);

  public void removePartOfSpeechFromWord(
      String wordId,
      String partOfSpeechId);

  public List<PartOfSpeechDTO> getAllPartsOfSpeech();
}
