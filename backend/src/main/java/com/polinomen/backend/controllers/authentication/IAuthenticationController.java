package com.polinomen.backend.controllers.authentication;

import com.polinomen.backend.dtos.requests.LoginRequest;
import com.polinomen.backend.dtos.requests.SignupRequest;

public interface IAuthenticationController {
  public String login(LoginRequest request);

  public String signup(SignupRequest request);
}
