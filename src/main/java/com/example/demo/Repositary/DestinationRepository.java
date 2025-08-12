package com.example.demo.Repositary;

import com.example.demo.Entity.Destination;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {
    List<Destination> findByTripsId(Long tripId);
}
