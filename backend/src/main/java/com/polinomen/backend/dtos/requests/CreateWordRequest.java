package com.polinomen.backend.dtos.requests;

import java.util.List;

public record CreateWordRequest(
    String name,
    List<String> partsOfSpeechIds,
    List<String> definitions) {

}
