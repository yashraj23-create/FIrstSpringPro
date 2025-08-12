package com.example.demo.Mapper;

import com.example.demo.DTO.TripDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        List<TripDTO> tripDTOs = user.getTrips()
                .stream()
                .map(TripMapper::toDTO)
                .collect(Collectors.toList());

        dto.setTripDTO(tripDTOs);
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setTrips(dto.getTripDTO().stream()
                .map(TripDTO -> TripMapper.toEntity(TripDTO,user)).toList());

        return user;
    }
}
