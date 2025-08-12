package com.example.demo.Mapper;

import com.example.demo.DTO.DestinationDTO;
import com.example.demo.Entity.Destination;
import com.example.demo.Entity.Trips;

public class DestinationMapper {
    public static DestinationDTO toDTO(Destination destination) {
        DestinationDTO dto = new DestinationDTO();
        dto.setId(destination.getId());
        dto.setCity(destination.getCity());
        dto.setMonuments(destination.getMonuments());
        dto.setTrip_id(destination.getTrips().getId());
        return dto;
    }

    public static Destination toEntity(DestinationDTO dto, Trips trip) {
        Destination destination = new Destination();
        destination.setCity(dto.getCity());
        destination.setMonuments(dto.getMonuments());
        destination.setTrips(trip); // trip must be fetched before calling this
        return destination;
    }
}
