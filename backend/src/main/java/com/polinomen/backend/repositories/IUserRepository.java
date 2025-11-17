package com.polinomen.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polinomen.backend.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
  public Optional<User> findByEmail(String email);
}
