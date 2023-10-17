package com.example.onlineticketingsystem.service;

import com.example.onlineticketingsystem.DTO.PassengerDTO;
import com.example.onlineticketingsystem.entity.Passenger;
import com.example.onlineticketingsystem.repo.PassengerRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;
    @Autowired
    private ModelMapper modelMapper;

    public PassengerDTO savePassenger(PassengerDTO passengerDTO){
        passengerRepo.save(modelMapper.map(passengerDTO, Passenger.class));
        return passengerDTO;
    }

    public PassengerDTO getPassengerById (int userID){
        Passenger passenger = passengerRepo.getPassengerById(userID);
        return modelMapper.map(passenger,PassengerDTO.class);
    }

    public int getPassengerByIdBalance (int userID){
        return passengerRepo.getPassengerByIdBalance(userID);
    }

    public void updateBalanceByUserId(int amount, int userID) {
        passengerRepo.updateBalanceByUserId(amount, userID);
    }

    public int getBalanceByUserId(int userId) {
        return passengerRepo.getBalanceByUserId(userId);
    }

    public boolean existsByUserIdAndPassword(int userID, String password) {
        return passengerRepo.existsByUserIdAndPassword(userID, password);
    }


}
