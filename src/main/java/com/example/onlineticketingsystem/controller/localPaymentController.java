package com.example.onlineticketingsystem.controller;

import com.example.onlineticketingsystem.DTO.LocalPaymentDTO;
import com.example.onlineticketingsystem.entity.LocalPayment;
import com.example.onlineticketingsystem.service.LocalPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/tickets")
@CrossOrigin
public class localPaymentController {
    @Autowired
    private LocalPaymentService localPaymentService;
    @PostMapping("/saveLocalPayment")
    public LocalPaymentDTO saveUser(@RequestBody LocalPaymentDTO localPaymentDTO){
        return localPaymentService.saveLocalPayment(localPaymentDTO);
    }

    @GetMapping("/getLocalPayment/{userID}")
    public List<LocalPayment> getLocalPaymentByUserId(@PathVariable int userID){
        return localPaymentService.getLocalPaymentByUserId(userID);
    }

    @GetMapping("/getLocalUniquePayment/{userID}/{refNumber}")
    public List<LocalPayment> getLocalPaymentByUserIdAndRef(@PathVariable int userID,@PathVariable String refNumber){
        return localPaymentService.getLocalPaymentByUserIdAndRef(userID,refNumber);
    }
}
