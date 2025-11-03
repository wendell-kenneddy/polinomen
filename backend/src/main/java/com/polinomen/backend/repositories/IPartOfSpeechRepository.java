package com.polinomen.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.PartOfSpeech;

@Repository
public interface IPartOfSpeechRepository extends JpaRepository<PartOfSpeech, String> {

}
