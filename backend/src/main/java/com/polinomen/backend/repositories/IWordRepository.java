package com.polinomen.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.Word;

@Repository
public interface IWordRepository extends JpaRepository<Word, String> {
}
