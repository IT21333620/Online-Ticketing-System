package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
}
