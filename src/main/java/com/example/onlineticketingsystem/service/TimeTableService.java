package com.example.onlineticketingsystem.service;

import com.example.onlineticketingsystem.DTO.TimeTableDTO;
import com.example.onlineticketingsystem.entity.TimeTable;
import com.example.onlineticketingsystem.repo.TimeTableRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Transactional
public class TimeTableService {

    @Autowired
    private TimeTableRepo timeTableRepo;

    @Autowired
    private ModelMapper modelMapper;

    public TimeTableDTO saveTimetable(TimeTableDTO timeTableDTO){
        timeTableRepo.save(modelMapper.map(timeTableDTO, TimeTable.class));
        return timeTableDTO;
    }

    @GetMapping("/getTimetable")
    public List<TimeTableDTO> getAllTimetable(){
        List<TimeTable>timeTableList = timeTableRepo.findAll();
        return modelMapper.map(timeTableList, new TypeToken<List<TimeTableDTO>>(){}.getType());
    }

    public TimeTableDTO updateTimetable(TimeTableDTO timeTableDTO){
        timeTableRepo.save(modelMapper.map(timeTableDTO, TimeTable.class));
        return timeTableDTO;
    }

    public boolean deleteTimetable(TimeTableDTO timeTableDTO){
        timeTableRepo.delete(modelMapper.map(timeTableDTO, TimeTable.class));
        return true;
    }
}
