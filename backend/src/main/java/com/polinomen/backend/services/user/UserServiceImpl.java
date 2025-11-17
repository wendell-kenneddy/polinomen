package com.polinomen.backend.services.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.polinomen.backend.dtos.UserDTO;
import com.polinomen.backend.mappers.IUserMapper;
import com.polinomen.backend.model.User;
import com.polinomen.backend.repositories.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
  private final IUserRepository userRepository;
  private final IUserMapper userMapper;

  public UserServiceImpl(IUserRepository userRepository, IUserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public UserDTO getProfile(Authentication authentication) throws UsernameNotFoundException {
    User user = this.userRepository.findById(authentication.getName())
        .orElseThrow(() -> new UsernameNotFoundException("Profile not found."));
    return this.userMapper.entityToDTO(user);
  }

}
