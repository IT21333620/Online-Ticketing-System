package com.example.onlineticketingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketInspectorDTO extends UserDTO{
    private int userID;
    private String name;
    private String email;
    private String contactNo;
    private String password;
    private String userType;
    private int inspectorId;

}
