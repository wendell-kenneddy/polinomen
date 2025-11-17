package com.polinomen.backend.model;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "words")
@Builder
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Word {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dictionary_id")
  private Dictionary dictionary;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "word", cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE,
      CascadeType.REMOVE })
  private List<Definition> defintions;

  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
  @JoinTable(name = "words_parts_of_speech", joinColumns = @JoinColumn(name = "word_id"), inverseJoinColumns = @JoinColumn(name = "part_of_speech_id"))
  private List<PartOfSpeech> partsOfSpeech;

  public Word setPartsOfSpeech(List<PartOfSpeech> partsOfSpeech) {
    this.partsOfSpeech = partsOfSpeech;
    return this;
  }

  public Word setDefinitions(List<Definition> definitions) {
    this.defintions = definitions;
    return this;
  }

  @CreationTimestamp
  private Instant createdAt;

  @UpdateTimestamp
  private Instant updatedAt;

}
