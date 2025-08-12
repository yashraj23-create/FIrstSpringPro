package com.example.demo.Mapper;

import com.example.demo.DTO.UserIdentityDTO;
import com.example.demo.Entity.UserIdentity;

public class IdentityMapper {
    public static UserIdentityDTO toDTO(UserIdentity entity) {

        UserIdentityDTO dto = new UserIdentityDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        return dto;
    }

    // DTO to Entity
    public static UserIdentity toEntity(UserIdentityDTO dto) {

        UserIdentity entity = new UserIdentity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
