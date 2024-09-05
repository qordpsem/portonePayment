package com.example.portonepayment.service;

import com.example.portonepayment.entity.Merchandise;
import com.example.portonepayment.repository.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public Merchandise findByNUM(int num){
        return merchandiseRepository.findById(num).orElseThrow(()-> new NoSuchElementException("없습니다" + num));
    }
    public void delete(int num){
        merchandiseRepository.deleteById(num);
    }
}
