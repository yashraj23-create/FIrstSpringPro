package com.example.demo.Repositary;

import com.example.demo.Entity.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trips,Long> {

}
