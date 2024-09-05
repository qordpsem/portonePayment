package com.example.portonepayment.controller;


import com.example.portonepayment.repository.ClientRepository;
import com.example.portonepayment.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signIn")
    public void signIn() {
    }

    @GetMapping("/signUp")
    public void signUp() {

    }

    @PostMapping("/signUp")
    public String signUp(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setRole("user");
        clientRepository.save(client);
        return "redirect:/signIn";
    }


}
