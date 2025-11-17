package com.polinomen.backend.repositories;

import com.polinomen.backend.model.Word;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IWordRepository extends JpaRepository<Word, String> {
  @Query("SELECT w FROM Word w WHERE w.dictionary.id = :dictionaryId")
  List<Word> findAllByDictionaryId(@Param("dictionaryId") String dictionaryId);

  @Modifying
  @Query("UPDATE Word w SET w.name = :name WHERE w.id = :wordId")
  void updateWordNameById(
      @Param("wordId") String wordId,
      @Param("name") String name);
}
