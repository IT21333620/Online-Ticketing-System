package com.example.onlineticketingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RouteDTO {
    private int id;
    private int routeNo;
    private String start;
    private String end;
    private String status;
}
