package com.polinomen.backend.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polinomen.backend.dtos.UserDTO;
import com.polinomen.backend.services.user.IUserService;

@RestController
public class UserController {
  private final IUserService userService;

  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users/profile")
  public UserDTO getProfile(Authentication authentication) {
    return this.userService.getProfile(authentication);
  }
}
