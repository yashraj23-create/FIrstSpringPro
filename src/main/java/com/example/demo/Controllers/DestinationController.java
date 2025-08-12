package com.example.demo.Controllers;

import com.example.demo.DTO.DestinationDTO;
import com.example.demo.Service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    @PostMapping
    public ResponseEntity<DestinationDTO> createDestination(@RequestBody DestinationDTO destinationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(destinationService.createDestination(destinationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationDTO> getDestination(@PathVariable Long id) {
        return ResponseEntity.ok(destinationService.getDestinationById(id));
    }

    @GetMapping("/trip/{tripId}")
    public ResponseEntity<List<DestinationDTO>> getDestinationsByTripId(@PathVariable Long tripId) {
        return ResponseEntity.ok(destinationService.getDestinationsByTripId(tripId));
    }

    @GetMapping
    public ResponseEntity<List<DestinationDTO>> getAllDestinations() {
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.ok("Destination deleted successfully");
    }
}
