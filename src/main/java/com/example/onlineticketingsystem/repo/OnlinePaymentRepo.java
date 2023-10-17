package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.LocalPayment;
import com.example.onlineticketingsystem.entity.OnlinePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OnlinePaymentRepo extends JpaRepository<OnlinePayment,Integer> {

    @Query(value = "SELECT * FROM online_payment WHERE userID = ?1", nativeQuery = true)
    List<OnlinePayment> getOnlinePaymentsByUserId(int userID);
}
