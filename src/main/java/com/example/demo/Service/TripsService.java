package com.example.demo.Service;

import com.example.demo.DTO.TripDTO;
import com.example.demo.EXceptionHandling.UserNotThere;
import com.example.demo.Entity.Trips;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.TripMapper;
import com.example.demo.Repositary.TripRepository;
import com.example.demo.Repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripsService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserRepository userRepository;

    public TripDTO createTrip(TripDTO tripDTO) {
        // fetch user
        User user = userRepository.findById(tripDTO.getUser_id())
                .orElseThrow(() -> new UserNotThere("User not found"));

        Trips trip = TripMapper.toEntity(tripDTO,user);

        Trips savedTrip = tripRepository.save(trip);

        return TripMapper.toDTO(savedTrip);
    }

    public TripDTO getTripById(Long id) {
        Trips trip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
        return TripMapper.toDTO(trip);
    }

    public List<TripDTO> getAllTrips() {
        return tripRepository.findAll()
                .stream()
                .map(TripMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TripDTO> getTripsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Userid is wrong"));

        return user.getTrips().stream().map(TripMapper::toDTO).toList();
    }

    public void deleteTrip(Long id) {
        if (!tripRepository.existsById(id)) {
            throw new RuntimeException("Trip not found");
        }
        tripRepository.deleteById(id);
    }
}
