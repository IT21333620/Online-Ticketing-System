package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepo extends JpaRepository<Bus, Integer> {
}
