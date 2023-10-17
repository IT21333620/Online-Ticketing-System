package com.example.onlineticketingsystem.service;

import com.example.onlineticketingsystem.DTO.LocalPaymentDTO;
import com.example.onlineticketingsystem.DTO.OnlinePaymentDTO;
import com.example.onlineticketingsystem.entity.LocalPayment;
import com.example.onlineticketingsystem.entity.OnlinePayment;
import com.example.onlineticketingsystem.repo.LocalPaymentRepo;
import com.example.onlineticketingsystem.repo.OnlinePaymentRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OnlinePaymentService {
    @Autowired
    private OnlinePaymentRepo onlinePaymentRepo;

    @Autowired
    private ModelMapper modelMapper;

    //data insertion
    public OnlinePaymentDTO saveOnlinePayment(OnlinePaymentDTO onlinePaymentDTO) {
        onlinePaymentRepo.save(modelMapper.map(onlinePaymentDTO, OnlinePayment.class));
        return onlinePaymentDTO;
    }

    public List<OnlinePayment> getOnlinePaymentByUserId(int userID){
        return onlinePaymentRepo.getOnlinePaymentsByUserId(userID);
    }
}
