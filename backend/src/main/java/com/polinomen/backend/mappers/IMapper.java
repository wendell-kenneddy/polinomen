package com.polinomen.backend.mappers;

public interface IMapper<Entity, DTO> {
  public DTO entityToDTO(Entity entity);

  public Entity DTOToEntity(DTO DTO);
}
