package com.example.onlineticketingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
    private int userID; // Changed from int to String
    private String name;
    private String email;
    private String contactNo;
    private String password;
    private String userType;
    private int balance;




}
