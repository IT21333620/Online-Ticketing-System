package com.example.onlineticketingsystem.service;

import com.example.onlineticketingsystem.DTO.BusDTO;
import com.example.onlineticketingsystem.entity.Bus;
import com.example.onlineticketingsystem.repo.BusRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BusService {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private ModelMapper modelMapper;

    public BusDTO saveBus(BusDTO busDTO){
        busRepo.save(modelMapper.map(busDTO, Bus.class));
        return busDTO;
    }

    public List<BusDTO> getAllBuses(){
        List<Bus>busList = busRepo.findAll();
        return modelMapper.map(busList, new TypeToken<List<BusDTO>>(){}.getType());
    }

    public BusDTO updateBus(BusDTO busDTO){
        busRepo.save(modelMapper.map(busDTO, Bus.class));
        return busDTO;
    }

    public boolean deleteBus(BusDTO busDTO){
        busRepo.delete(modelMapper.map(busDTO, Bus.class));
        return true;
    }
}
