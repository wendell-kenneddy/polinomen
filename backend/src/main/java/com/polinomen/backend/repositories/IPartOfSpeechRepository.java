package com.polinomen.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.PartOfSpeech;

@Repository
public interface IPartOfSpeechRepository extends JpaRepository<PartOfSpeech, String> {
  @Modifying
  @Query("UPDATE PartOfSpeech p SET p.name = :name, p.description = :description WHERE p.id = :id")
  void update(@Param("name") String name, @Param("descripion") String description, @Param("id") String id);
}
