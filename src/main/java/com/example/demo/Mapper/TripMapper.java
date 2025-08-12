package com.example.demo.Mapper;

import com.example.demo.DTO.DestinationDTO;
import com.example.demo.DTO.TripDTO;
import com.example.demo.Entity.Destination;
import com.example.demo.Entity.Trips;
import com.example.demo.Entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class TripMapper {
    public static TripDTO toDTO(Trips trip) {
        TripDTO dto = new TripDTO();
        dto.setId(trip.getId());
        dto.setTripName(trip.getTripName());
        dto.setStartDate(trip.getStartDate());
        dto.setEndDate(trip.getEndDate());
        dto.setUser_id(trip.getUser().getId());

        List<DestinationDTO> destDTOs = trip.getDestinations()
                .stream()
                .map(DestinationMapper::toDTO)
                .collect(Collectors.toList());

        dto.setDestinationDTOS(destDTOs);
        return dto;
    }

    public static Trips toEntity(TripDTO dto, User user) {
        Trips trip = new Trips();
        trip.setTripName(dto.getTripName());
        trip.setStartDate(dto.getStartDate());
        trip.setEndDate(dto.getEndDate());
        trip.setUser(user);

        // Map destinations
        List<Destination> destinations = dto.getDestinationDTOS()
                .stream()
                .map(d -> DestinationMapper.toEntity(d, trip))
                .collect(Collectors.toList());

        trip.setDestinations(destinations);
        return trip;
    }
}
