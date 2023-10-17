package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.TimeTableDTO;
import com.example.onlineticketingsystem.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/timetable")
@CrossOrigin
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    @PostMapping("/saveTimetable")
    public TimeTableDTO saveTimetable(@RequestBody TimeTableDTO timeTableDTO){
        return timeTableService.saveTimetable(timeTableDTO);
    }

    @GetMapping("/getTimetable")
    public List<TimeTableDTO> getTimetable(){
        return timeTableService.getAllTimetable();
    }

    @PutMapping("/updateTimetable")
    public TimeTableDTO updateTimetable(@RequestBody TimeTableDTO timeTableDTO){
        return timeTableService.updateTimetable(timeTableDTO);
    }

    @DeleteMapping("/deleteTimetable")
    public boolean deleteTimetable(@RequestBody TimeTableDTO timeTableDTO){
        return timeTableService.deleteTimetable(timeTableDTO);
    }
}
