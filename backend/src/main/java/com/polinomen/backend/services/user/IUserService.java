package com.polinomen.backend.services.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.polinomen.backend.dtos.UserDTO;

public interface IUserService {
  public UserDTO getProfile(Authentication authentication) throws UsernameNotFoundException;
}
