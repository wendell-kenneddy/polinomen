package com.polinomen.backend.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.polinomen.backend.repositories.IUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final IUserRepository userRepository;

  public UserDetailsServiceImpl(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
        .findByEmail(username)
        .map(UserDetailsImpl::new)
        .orElseThrow(() -> new UsernameNotFoundException("Invalid e-mail or password."));
  }
}