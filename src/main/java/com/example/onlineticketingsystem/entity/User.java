package com.example.onlineticketingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @NonNull
    private String name;
    @Column(unique = true)
    private String email;
    @NonNull
    private String contactNo;
    @NonNull
    private String password;
    @NonNull
    private String userType;
}

