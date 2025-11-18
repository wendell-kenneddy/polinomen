package com.polinomen.backend.controllers.user;

import org.springframework.security.core.Authentication;

import com.polinomen.backend.dtos.UserDTO;

public interface IUserController {
  public UserDTO getProfile(Authentication authentication);
}
