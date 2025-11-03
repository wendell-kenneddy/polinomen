package com.polinomen.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.Dictionary;

@Repository
public interface IDictionaryRepository extends JpaRepository<Dictionary, String> {

}
