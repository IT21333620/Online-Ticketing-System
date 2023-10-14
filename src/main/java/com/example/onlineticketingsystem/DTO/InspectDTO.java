package com.example.onlineticketingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectDTO {
    private int InspectId;
    private int inspectorId;
    private int busId;
    private Date inspectDate;
    private Time inspectTime;
    private int NofraudDetected;
    private int NoOFPssUsers;


    public void setInspectId(int inspectId) {
        InspectId = inspectId;
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
        NofraudDetected = nofraudDetected;
    }

    public void setNoOFPssUsers(int noOFPssUsers) {
        NoOFPssUsers = noOFPssUsers;
    }
}

