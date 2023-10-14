package com.example.onlineticketingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int busOwnerID;
    private int routeNo;
    private int capacity;
}
