package com.example.onlineticketingsystem.service;


import com.example.onlineticketingsystem.DTO.LocalPaymentDTO;
import com.example.onlineticketingsystem.entity.LocalPayment;
import com.example.onlineticketingsystem.repo.LocalPaymentRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LocalPaymentService {
    @Autowired
    private LocalPaymentRepo localPaymentRepo;

    @Autowired
    private ModelMapper modelMapper;

    //data insertion
    public LocalPaymentDTO saveLocalPayment(LocalPaymentDTO localPaymentDTO) {
        localPaymentRepo.save(modelMapper.map(localPaymentDTO, LocalPayment.class));
        return localPaymentDTO;
    }

    //retrieve all by id
    public List<LocalPayment> getLocalPaymentByUserId(int userID){
        return localPaymentRepo.getLocalPaymentsByUserId(userID);
    }

    //retrieve 1 by id
    public List<LocalPayment> getLocalPaymentByUserIdAndRef(int userID,String refNumber){
        return localPaymentRepo.getLocalPaymentsByUserIdAndRef(userID,refNumber);
    }
}
