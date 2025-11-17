package com.polinomen.backend.config;

import jakarta.transaction.Transactional;

import com.polinomen.backend.model.PartOfSpeech;
import com.polinomen.backend.repositories.IPartOfSpeechRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seed implements CommandLineRunner {
  @Value("${seed.enabled}")
  private Boolean shouldRun;
  private final IPartOfSpeechRepository partOfSpeechRepository;

  public Seed(IPartOfSpeechRepository partOfSpeechRepository) {
    this.partOfSpeechRepository = partOfSpeechRepository;
  }

  @Override
  @Transactional
  public void run(String... args) {
    if (shouldRun && this.partOfSpeechRepository.count() == 0) {
      this.partOfSpeechRepository.saveAll(
          List.of(
              PartOfSpeech.builder()
                  .name("Noun")
                  .description("A word that names a person, place, thing, or idea (e.g., dog, city, book, love)")
                  .build(),
              PartOfSpeech.builder()
                  .name("Pronoun")
                  .description(" A word that replaces a noun (e.g., he, she, it, they)")
                  .build(),
              PartOfSpeech.builder()
                  .name("Verb")
                  .description("A word that expresses an action or a state of being (e.g., run, jump, is, seems)")
                  .build(),
              PartOfSpeech.builder()
                  .name("Adjective")
                  .description("A word that describes or modifies a noun or pronoun (e.g., happy, blue, large).")
                  .build(),
              PartOfSpeech.builder()
                  .name("Noun")
                  .description("A word that names a person, place, thing, or idea")
                  .build(),
              PartOfSpeech.builder()
                  .name("Adverb")
                  .description(
                      "A word that modifies a verb, adjective, or another adverb, often indicating how, when, or where (e.g., quickly, yesterday, here).")
                  .build(),
              PartOfSpeech.builder()
                  .name("Preposition")
                  .description(
                      "A word that shows the relationship between a noun or pronoun and other words in a sentence (e.g., in, on, under, to).")
                  .build(),
              PartOfSpeech.builder()
                  .name("Conjunction")
                  .description("A word that connects words, phrases, or clauses (e.g., and, but, or).")
                  .build(),
              PartOfSpeech.builder()
                  .name("Interjection")
                  .description(" A word or phrase that expresses strong emotion (e.g., Wow!, Oh!, Ouch!). ")
                  .build()));
    }
  }

}