package com.example.portonepayment.service;

import com.example.portonepayment.entity.Client;
import com.example.portonepayment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(String id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = findById(username);
        if(client == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(client.getId())
                .password(client.getPassword())
                .roles(client.getRole())
                .build();
    }
}
