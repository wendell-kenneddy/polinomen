package com.polinomen.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.Definition;

@Repository
public interface IDefinitionRepository extends JpaRepository<Definition, String> {
  @Query("SELECT d FROM Definition d WHERE d.word.id = :wordId")
  public List<Definition> findAllByWordId(@Param("wordId") String wordId);

  @Modifying
  @Query("UPDATE Definition d SET d.description = :description WHERE d.id = :definitionId")
  public void updateDefinitionById(@Param("definitionId") String definitionId,
      @Param("description") String description);
}
