package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.PassengerDTO;
import com.example.onlineticketingsystem.DatabaseConnectionManager;
import com.example.onlineticketingsystem.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "api/tickets")
@CrossOrigin
public class PassengerController {

    private DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();

    @Autowired
    private PassengerService passengerService;

    //insert passenger
    @PostMapping("/createPassenger")
    public PassengerDTO savePassenger(@RequestBody PassengerDTO passengerDTO) {
        try (Connection connection = connectionManager.getConnection()) {
            // Use the 'connection' to perform database operations
            passengerService.savePassenger(passengerDTO);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or operation error
            // You might want to return an appropriate HTTP response in case of an error.
        }

        // Return a response indicating success
        return passengerDTO;
    }

    //show all feilds of passenger
    @GetMapping("/passengerById/{userID}")
    public PassengerDTO getPassengerById(@PathVariable int userID) {
        try (Connection connection = connectionManager.getConnection()) {
            // Use the 'connection' to perform database operations
            return passengerService.getPassengerById(userID);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or operation error
            // You might want to return an appropriate HTTP response in case of an error.
            return null; // or throw an exception, or handle the error as per your application's requirements.
        }
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
