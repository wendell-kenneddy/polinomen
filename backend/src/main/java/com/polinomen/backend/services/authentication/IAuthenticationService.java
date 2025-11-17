package com.polinomen.backend.services.authentication;

import com.polinomen.backend.dtos.requests.LoginRequest;
import com.polinomen.backend.dtos.requests.SignupRequest;

public interface IAuthenticationService {
  public String signup(SignupRequest request);

  public String login(LoginRequest request);
}
