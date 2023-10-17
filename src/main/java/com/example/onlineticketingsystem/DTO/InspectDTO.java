package com.example.onlineticketingsystem.DTO;

import com.example.onlineticketingsystem.entity.Inspect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectDTO {
    private int inspectId;
    private int inspectorId;
    private int busId;
    private int routeId;
    private Date inspectDate;
    private Time inspectTime;
    private int noFraudDetected;
    private int noOfPassengers;


    public void setInspectId(int inspectId) {
        inspectId = inspectId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }

    public void setInspectTime(Time inspectTime) {
        this.inspectTime = inspectTime;
    }

    public void setNofraudDetected(int nofraudDetected) {
        noFraudDetected = nofraudDetected;
    }

    public void setNoOFPssUsers(int noOFPssUsers) {
        noOfPassengers = noOFPssUsers;
    }


}

