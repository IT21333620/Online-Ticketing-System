package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTableRepo extends JpaRepository<TimeTable, Integer> {
}
