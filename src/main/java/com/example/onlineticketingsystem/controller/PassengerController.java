package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.PassengerDTO;
import com.example.onlineticketingsystem.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/tickets")
@CrossOrigin(origins = "http://localhost:3001")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    //insert passenger
    @PostMapping("/createPassenger")
    public PassengerDTO savePassenger (@RequestBody PassengerDTO passengerDTO){
        return passengerService.savePassenger(passengerDTO);
    }

    //show all feilds of passenger
    @GetMapping("/passengerById/{userID}")
    public PassengerDTO getPassengerById(@PathVariable int userID){
        return passengerService.getPassengerById(userID);
    }

    //show balance of passenger
    @GetMapping("/passengerBalance/{userID}")
    public int getPassengerByIdBalance(@PathVariable int userID){
        return passengerService.getPassengerByIdBalance(userID);
    }

    @PutMapping("/updateBalance/{amount}/{userID}")
    public ResponseEntity<Integer> updateBalanceByUserId(@PathVariable int amount,@PathVariable int userID) {
        passengerService.updateBalanceByUserId(amount, userID);
        int updatedBalance = passengerService.getBalanceByUserId(userID);
        return ResponseEntity.ok(updatedBalance);
    }

    @GetMapping("/checkPassenger/{userID}/{password}")
    public boolean existsByUserIdAndPassword(@PathVariable int userID, @PathVariable String password){
        return passengerService.existsByUserIdAndPassword(userID,password);
    }
}
