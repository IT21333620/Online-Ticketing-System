package com.example.onlineticketingsystem.service;

import com.example.onlineticketingsystem.DTO.RouteDTO;
import com.example.onlineticketingsystem.entity.Route;
import com.example.onlineticketingsystem.repo.RouteRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RouteService {
    @Autowired
    private RouteRepo routeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public RouteDTO saveRoute(RouteDTO routeDTO){
        routeRepo.save(modelMapper.map(routeDTO, Route.class));
        return routeDTO;
    }

    public List<RouteDTO> getAllRoutes(){
        List<Route>routeList = routeRepo.findAll();
        return modelMapper.map(routeList, new TypeToken<List<RouteDTO>>(){}.getType());
    }

    public RouteDTO updateRoute(RouteDTO routeDTO){
        routeRepo.save(modelMapper.map(routeDTO, Route.class));
        return routeDTO;
    }

    public boolean deleteRoute(RouteDTO routeDTO){
        routeRepo.delete(modelMapper.map(routeDTO, Route.class));
        return true;
    }
}
