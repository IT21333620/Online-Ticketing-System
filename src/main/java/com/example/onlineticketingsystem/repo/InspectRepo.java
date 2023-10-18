package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.Inspect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;


public interface InspectRepo extends JpaRepository<Inspect,Integer> {
    List<Inspect> findByInspectorId(int inspectorId);

    List<Inspect> findByInspectDate(Date inspectDate);

    List<Inspect> findByInspectorIdAndInspectDateBetween(int inspectorId, Date startDate, Date endDate);

    Inspect findByInspectId(int inspect_id);

}
