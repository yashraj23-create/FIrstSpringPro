package com.example.demo.Controllers;

import com.example.demo.DTO.TripDTO;
import com.example.demo.Service.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripsController {
    @Autowired
    private TripsService tripService;

    @PostMapping
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO tripDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tripService.createTrip(tripDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDTO> getTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @GetMapping
    public ResponseEntity<List<TripDTO>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TripDTO>> getTripsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(tripService.getTripsByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.ok("Trip deleted successfully");
    }
}
