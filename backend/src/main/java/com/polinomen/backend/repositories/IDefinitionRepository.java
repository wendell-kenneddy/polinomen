package com.polinomen.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.Definition;

@Repository
public interface IDefinitionRepository extends JpaRepository<Definition, String> {

}
