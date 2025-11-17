package com.polinomen.backend.services.authentication;

import com.polinomen.backend.dtos.requests.LoginRequest;
import com.polinomen.backend.dtos.requests.SignupRequest;
import com.polinomen.backend.model.User;
import com.polinomen.backend.repositories.IUserRepository;
import com.polinomen.backend.security.UserDetailsImpl;
import com.polinomen.backend.services.jwt.IJWTService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
  private final IUserRepository userRepository;
  private final IJWTService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final DaoAuthenticationProvider daoAuthenticationProvider;

  public AuthenticationServiceImpl(
      IUserRepository userRepository,
      IJWTService jwtService,
      PasswordEncoder passwordEncoder,
      DaoAuthenticationProvider daoAuthenticationProvider) {
    this.userRepository = userRepository;
    this.jwtService = jwtService;
    this.passwordEncoder = passwordEncoder;
    this.daoAuthenticationProvider = daoAuthenticationProvider;
  }

  public String signup(SignupRequest request) {
    User user = User.builder()
        .username(request.username())
        .email(request.email())
        .password(this.passwordEncoder.encode(request.password()))
        .build();
    UserDetails userDetails = new UserDetailsImpl(this.userRepository.save(user));
    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
        userDetails,
        null,
        userDetails.getAuthorities());
    String token = jwtService.generateToken(authentication, user.getId());
    return token;
  }

  public String login(LoginRequest request) {
    User user = User.builder().email(request.email()).password(request.password()).build();
    UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(
        user.getEmail(),
        user.getPassword());
    Authentication authentication = this.daoAuthenticationProvider.authenticate(token);
    return jwtService.generateToken(authentication, ((UserDetailsImpl) authentication.getPrincipal()).getId());
  }
}