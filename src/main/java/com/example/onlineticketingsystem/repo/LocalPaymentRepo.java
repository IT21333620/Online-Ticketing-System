package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.LocalPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalPaymentRepo extends JpaRepository<LocalPayment,Integer> {

    @Query(value = "SELECT * FROM local_payment WHERE userID = ?1", nativeQuery = true)
    List<LocalPayment> getLocalPaymentsByUserId(int userID);

    @Query(value = "SELECT * FROM local_payment WHERE userID = ?1 and ref_number = ?2", nativeQuery = true)
    List<LocalPayment> getLocalPaymentsByUserIdAndRef(int userID,String refNumber);


}
