package com.example.onlineticketingsystem.repo;


import com.example.onlineticketingsystem.entity.TicketInspector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketInspectorRepo extends JpaRepository<TicketInspector,Integer> {
    List<TicketInspector> findByInspectorID(int inspectorID);
}
