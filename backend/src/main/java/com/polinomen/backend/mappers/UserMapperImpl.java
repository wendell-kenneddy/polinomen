package com.polinomen.backend.mappers;

import org.springframework.stereotype.Component;

import com.polinomen.backend.dtos.UserDTO;
import com.polinomen.backend.model.User;

@Component
public class UserMapperImpl implements IUserMapper {
  @Override
  public User DTOToEntity(UserDTO DTO) {
    return User.builder()
        .username(DTO.username())
        .email(DTO.email())
        .createdAt(DTO.createdAt())
        .updatedAt(DTO.updatedAt())
        .build();
  }

  @Override
  public UserDTO entityToDTO(User entity) {
    return new UserDTO(
        entity.getUsername(),
        entity.getEmail(),
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }
}
