package com.example.portonepayment.controller;

import com.example.portonepayment.entity.Payment;
import com.example.portonepayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payok")
    public String payOK(Payment p) {
        System.out.println("payOK 동작함");
        p.setNo(paymentService.getNextNo());
        paymentService.save(p);
        return "OK";
    }
}
