package com.example.onlineticketingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusOwner extends User{

    private int registrationNo;
    private String ownedBuses;
}
