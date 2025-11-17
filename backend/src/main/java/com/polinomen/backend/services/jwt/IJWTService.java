package com.polinomen.backend.services.jwt;

import org.springframework.security.core.Authentication;

public interface IJWTService {
  public String generateToken(Authentication authentication, String subject);
}
