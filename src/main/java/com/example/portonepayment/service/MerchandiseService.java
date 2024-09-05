package com.example.portonepayment.service;

import com.example.portonepayment.entity.Merchandise;
import com.example.portonepayment.repository.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchandiseService {

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    public List<Merchandise> findAll(){
        return merchandiseRepository.findAll();
    }

    public void insert(Merchandise merchandise){
        merchandiseRepository.save(merchandise);
    }
}
