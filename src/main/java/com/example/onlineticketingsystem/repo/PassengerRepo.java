package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<Passenger,Integer> {

}
