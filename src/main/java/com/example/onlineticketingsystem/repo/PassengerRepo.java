package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
    @Query(value = "SELECT * FROM passenger WHERE userID = ?1",nativeQuery = true)
    Passenger getPassengerById (int userID);

    @Query(value = "SELECT userID,balance FROM passenger WHERE userID = ?1",nativeQuery = true)
    int getPassengerByIdBalance (int userID);

    @Modifying
    @Query(value = "UPDATE passenger SET balance = balance + ?1 WHERE userID = ?2", nativeQuery = true)
    void updateBalanceByUserId(@Param("amount") int amount, @Param("userId") int userId);

    @Query(value = "SELECT balance FROM passenger WHERE userID = ?1", nativeQuery = true)
    int getBalanceByUserId(@Param("userId") int userId);

    @Query(value = "SELECT COUNT(p) > 0 FROM Passenger p WHERE p.userID = ?1 AND p.password = ?2")
    boolean existsByUserIdAndPassword(@Param("userId") int userId, @Param("password") String password);

}
