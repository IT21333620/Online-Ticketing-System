package com.example.onlineticketingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusDTO {
    private int id;
    private int busOwnerID;
    private int routeNo;
    private int capacity;
}
