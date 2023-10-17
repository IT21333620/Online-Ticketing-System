package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.RouteDTO;
import com.example.onlineticketingsystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/route")
@CrossOrigin
public class RouteController {
    @Autowired
    private RouteService routeService;

    @PostMapping("/saveRoute")
    public RouteDTO saveRoute(@RequestBody RouteDTO routeDTO){
        return routeService.saveRoute(routeDTO);
    }

    @GetMapping("/getRoute")
    public List<RouteDTO> getRoute(){
        return routeService.getAllRoutes();
    }

    @PutMapping("/updateRoute")
    public RouteDTO updateRoute(@RequestBody RouteDTO routeDTO){
        return routeService.updateRoute(routeDTO);
    }


    @DeleteMapping("/deleteRoute")
    public boolean deleteRoute(@RequestBody RouteDTO routeDTO){
        return routeService.deleteRoute(routeDTO);
    }
}