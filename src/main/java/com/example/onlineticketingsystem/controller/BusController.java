package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.BusDTO;
import com.example.onlineticketingsystem.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/bus")
@CrossOrigin
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping("/getBus")
    public List<BusDTO> getBus(){
        return busService.getAllBuses();
    }

    @PutMapping("/updateBus")
    public BusDTO updateBus(@RequestBody BusDTO busDTO){
        return busService.updateBus(busDTO);
    }

    @DeleteMapping("/deleteBus")
    public boolean deleteBus(@RequestBody BusDTO busDTO){
        return busService.deleteBus(busDTO);
    }

    @PostMapping("/saveBus")
    public BusDTO saveBus(@RequestBody BusDTO busDTO){
        return busService.saveBus(busDTO);
    }




}
