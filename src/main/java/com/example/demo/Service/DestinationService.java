package com.example.demo.Service;

import com.example.demo.DTO.DestinationDTO;
import com.example.demo.Entity.Destination;
import com.example.demo.Entity.Trips;
import com.example.demo.Mapper.DestinationMapper;
import com.example.demo.Repositary.DestinationRepository;
import com.example.demo.Repositary.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;
    @Autowired
    private TripRepository tripRepository;
    public DestinationDTO createDestination(DestinationDTO destinationDTO) {
        Trips trip = tripRepository.findById(destinationDTO.getTrip_id())
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        Destination destination = DestinationMapper.toEntity(destinationDTO,trip);
        destination.setTrips(trip);

        Destination saved = destinationRepository.save(destination);
        return DestinationMapper.toDTO(saved);
    }

    public DestinationDTO getDestinationById(Long id) {
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found"));
        return DestinationMapper.toDTO(destination);
    }

    public List<DestinationDTO> getDestinationsByTripId(Long tripId) {
        List<Destination> destinations = destinationRepository.findByTripsId(tripId);
        return destinations.stream()
                .map(DestinationMapper::toDTO)
                .collect(Collectors.toList());
    }
    public List<DestinationDTO> getAllDestinations() {
        return destinationRepository.findAll()
                .stream()
                .map(DestinationMapper::toDTO)
                .collect(Collectors.toList());
    }
    public void deleteDestination(Long id) {
        if (!destinationRepository.existsById(id)) {
            throw new RuntimeException("Destination not found");
        }
        destinationRepository.deleteById(id);
    }
}
