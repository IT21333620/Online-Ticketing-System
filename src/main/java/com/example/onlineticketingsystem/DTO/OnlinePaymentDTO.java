package com.example.onlineticketingsystem.DTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OnlinePaymentDTO {
    private int paymentID;
    private int userID;
    private float amount;
    private LocalDate date;
    private String type;
}
