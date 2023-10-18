package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.TicketInspectorDTO;
import com.example.onlineticketingsystem.entity.TicketInspector;
import com.example.onlineticketingsystem.service.TicketInspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/Inspector")
@CrossOrigin
public class TicketInspectorController {

    @Autowired
    private TicketInspectorService ticketInspectorService;


    @GetMapping("/getInspector")
    public List<TicketInspectorDTO> getAllInspectors(){
        return ticketInspectorService.getAllInspectors();
    }

    @GetMapping("/byInspector/{id}")
    public List<TicketInspector> getInspectorById(@PathVariable int id) {

        return ticketInspectorService.getInspectorById(id);
    }


}
