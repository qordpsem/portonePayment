package com.example.portonepayment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="client")
public class Client {
    @Id
    private String id;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String address;
    private int postcode;
    private String role;
}
