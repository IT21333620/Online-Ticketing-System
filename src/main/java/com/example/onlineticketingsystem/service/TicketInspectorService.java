package com.example.onlineticketingsystem.service;

import com.example.onlineticketingsystem.DTO.TicketInspectorDTO;
import com.example.onlineticketingsystem.entity.TicketInspector;
import com.example.onlineticketingsystem.repo.TicketInspectorRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TicketInspectorService {

    @Autowired
    private TicketInspectorRepo ticketInspectorRepo;
    @Autowired
    private ModelMapper modelMapper;


    public List<TicketInspectorDTO> getAllInspectors(){
        List<TicketInspector> inspectList= ticketInspectorRepo.findAll();
        return modelMapper.map(inspectList, new TypeToken<List<TicketInspector>>(){}.getType());
    }

    public List<TicketInspector> getInspectorById(int inspectorId) {
        return ticketInspectorRepo.findByInspectorID(inspectorId);
    }
}
