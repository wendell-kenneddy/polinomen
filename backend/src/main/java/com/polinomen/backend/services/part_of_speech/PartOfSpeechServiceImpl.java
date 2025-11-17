package com.polinomen.backend.services.part_of_speech;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polinomen.backend.dtos.PartOfSpeechDTO;
import com.polinomen.backend.dtos.requests.AddPartOfSpeechToWordRequest;
import com.polinomen.backend.mappers.IPartOfSpeechMapper;
import com.polinomen.backend.model.PartOfSpeech;
import com.polinomen.backend.model.Word;
import com.polinomen.backend.repositories.IPartOfSpeechRepository;
import com.polinomen.backend.repositories.IWordRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PartOfSpeechServiceImpl implements IPartOfSpeechService {
  private final IPartOfSpeechRepository partOfSpeechRepository;
  private final IWordRepository wordRepository;
  private final IPartOfSpeechMapper partOfSpeechMapper;

  public PartOfSpeechServiceImpl(
      IPartOfSpeechRepository partOfSpeechRepository,
      IWordRepository wordRepository,
      IPartOfSpeechMapper partOfSpeechMapper) {
    this.partOfSpeechRepository = partOfSpeechRepository;
    this.wordRepository = wordRepository;
    this.partOfSpeechMapper = partOfSpeechMapper;
  }

  public List<PartOfSpeechDTO> getAllPartsOfSpeech() {
    return this.partOfSpeechRepository
        .findAll()
        .stream()
        .map(this.partOfSpeechMapper::entityToDTO)
        .toList();
  }

  public void addExistingPartOfSpeechToWord(String wordId, AddPartOfSpeechToWordRequest request) {
    Word existingWord = this.wordRepository.findById(wordId)
        .orElseThrow(() -> new EntityNotFoundException("Word not found."));
    PartOfSpeech partOfSpeech = this.partOfSpeechRepository.findById(request.partOfSpeechId())
        .orElseThrow(() -> new EntityNotFoundException("Part of speech not found."));
    existingWord.getPartsOfSpeech().add(partOfSpeech);
    this.wordRepository.save(existingWord);
  }

  public void removePartOfSpeechFromWord(String wordId, String partOfSpeechId) {
    Word existingWord = this.wordRepository.findById(wordId)
        .orElseThrow(() -> new EntityNotFoundException("Word not found."));
    PartOfSpeech partOfSpeech = this.partOfSpeechRepository.findById(partOfSpeechId)
        .orElseThrow(() -> new EntityNotFoundException("Part of speech not found."));
    existingWord.getPartsOfSpeech().remove(partOfSpeech);
    this.wordRepository.save(existingWord);
  }

}
