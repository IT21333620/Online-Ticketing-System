package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.LocalPaymentDTO;
import com.example.onlineticketingsystem.DTO.OnlinePaymentDTO;
import com.example.onlineticketingsystem.entity.LocalPayment;
import com.example.onlineticketingsystem.entity.OnlinePayment;
import com.example.onlineticketingsystem.service.LocalPaymentService;
import com.example.onlineticketingsystem.service.OnlinePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/tickets")
@CrossOrigin
public class OnlinePaymentController {
    @Autowired
    private OnlinePaymentService onlinePaymentService;

    @PostMapping("/saveOnlinePayment")
    public OnlinePaymentDTO saveUser(@RequestBody OnlinePaymentDTO onlinePaymentDTO){
        return onlinePaymentService.saveOnlinePayment(onlinePaymentDTO);
    }

    @GetMapping("/getOnlinePayment/{userID}")
    public List<OnlinePayment> getOnlinePaymentByUserId(@PathVariable int userID){
        return onlinePaymentService.getOnlinePaymentByUserId(userID);
    }
}
