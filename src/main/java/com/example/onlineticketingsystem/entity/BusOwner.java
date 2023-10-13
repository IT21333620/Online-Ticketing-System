package com.example.onlineticketingsystem.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
