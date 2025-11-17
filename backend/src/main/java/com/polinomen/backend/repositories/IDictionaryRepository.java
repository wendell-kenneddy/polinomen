package com.polinomen.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.Dictionary;

@Repository
public interface IDictionaryRepository extends JpaRepository<Dictionary, String> {
  @Query(value = "SELECT d FROM Dictionary d WHERE d.user.id = :userId")
  public List<Dictionary> findAllByUserId(@Param("userId") String userId);

  @Modifying
  @Query("UPDATE Dictionary d SET d.name = :name, d.description = :description WHERE d.id = :id")
  public void updateById(
      @Param("id") String dictionaryId,
      @Param("name") String name,
      @Param("description") String description);

}
