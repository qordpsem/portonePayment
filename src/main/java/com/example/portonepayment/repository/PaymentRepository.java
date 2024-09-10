package com.example.portonepayment.repository;

import com.example.portonepayment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value= "select nvl(max(no),0)+1 from payment", nativeQuery = true)
    public int getNextNo();

}
