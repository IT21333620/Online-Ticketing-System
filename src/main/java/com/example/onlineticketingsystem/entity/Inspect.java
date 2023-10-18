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
public class Inspect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inspectId;
    private int inspectorId;
    private int busId;
    private int routeId;
    private Date inspectDate;
    private Time inspectTime;
    private int noFraudDetected;
    private int noOfPassengers;

}
