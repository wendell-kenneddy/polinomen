package com.polinomen.backend.mappers;

import com.polinomen.backend.dtos.ShortWordDTO;
import com.polinomen.backend.dtos.WordDTO;
import com.polinomen.backend.model.Word;

public interface IWordMapper extends IMapper<Word, WordDTO> {
  public ShortWordDTO entityToShortDTO(Word entity);
}
