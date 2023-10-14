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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busownerID;

    @ElementCollection
    private List<String> ownedBuses;
}
