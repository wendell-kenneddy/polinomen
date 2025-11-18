package com.polinomen.backend.controllers.part_of_speech;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polinomen.backend.dtos.PartOfSpeechDTO;
import com.polinomen.backend.dtos.requests.AddPartOfSpeechToWordRequest;
import com.polinomen.backend.services.part_of_speech.IPartOfSpeechService;

@RestController
public class PartOfSpeechControllerImpl implements IPartOfSpeechController {
  private final IPartOfSpeechService partOfSpeechService;

  public PartOfSpeechControllerImpl(IPartOfSpeechService partOfSpeechService) {
    this.partOfSpeechService = partOfSpeechService;
  }

  @PostMapping("/dictionaries/{dictionaryId}/words/{wordId}/parts-of-speech")
  public void addExistingPartOfSpeechToWord(@PathVariable String wordId,
      @RequestBody AddPartOfSpeechToWordRequest request) {
    this.partOfSpeechService.addExistingPartOfSpeechToWord(wordId, request);

  }

  @PostMapping("/dictionaries/{dictionaryId}/words/{wordId}/parts-of-speech/{partOfSpeechId}")
  public void removePartOfSpeechFromWord(
      @PathVariable String wordId,
      @PathVariable String partOfSpeechId) {
    this.partOfSpeechService.removePartOfSpeechFromWord(wordId, wordId);

  }

  @GetMapping("/parts-of-speech")
  public List<PartOfSpeechDTO> getAllPartsOfSpeech() {
    return this.partOfSpeechService.getAllPartsOfSpeech();
  }

}
