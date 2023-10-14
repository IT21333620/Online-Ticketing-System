package com.example.onlineticketingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimeTableDTO {
    private int scheduleNo;
    private int routeID;
    private int busID;
    private String day;
    private Time StartTime;
}
