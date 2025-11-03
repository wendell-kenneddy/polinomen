package com.polinomen.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {

}
