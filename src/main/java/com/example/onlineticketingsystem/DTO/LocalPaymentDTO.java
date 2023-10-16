package com.example.onlineticketingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocalPaymentDTO {
    private int paymentID;
    private int userID;
    private String branch;
    private String refNumber;
    private float amount;
    private LocalDate date;
    private String type;
}
