package com.example.portonepayment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Data
@Table(name="merchandise")
public class Merchandise {
    @Id
    private int num;
    private String name;
    private int price;
    private int amount;
    private String fname;
    private int fsize;
    @Transient
    private MultipartFile uploadFile;

}
