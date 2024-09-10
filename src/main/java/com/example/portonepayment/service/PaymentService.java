package com.example.portonepayment.service;

import com.example.portonepayment.entity.Payment;
import com.example.portonepayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public int getNextNo(){
        return paymentRepository.getNextNo();
    }

    public void save(Payment p){
        p.setNo(getNextNo());
        paymentRepository.save(p);
    }
}
