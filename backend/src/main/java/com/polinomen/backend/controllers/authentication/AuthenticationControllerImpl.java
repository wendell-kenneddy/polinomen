package com.polinomen.backend.controllers.authentication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polinomen.backend.dtos.requests.LoginRequest;
import com.polinomen.backend.dtos.requests.SignupRequest;
import com.polinomen.backend.services.authentication.IAuthenticationService;

@RestController
public class AuthenticationControllerImpl implements IAuthenticationController {
  private IAuthenticationService authenticationService;

  public AuthenticationControllerImpl(IAuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("/auth/login")
  public String login(@RequestBody LoginRequest request) {
    return this.authenticationService.login(request);
  }

  @PostMapping("/auth/signup")
  public String signup(@RequestBody SignupRequest request) {
    return this.authenticationService.signup(request);
  }
}
