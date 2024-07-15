package com.example.volunteeringApp.services;

import com.example.volunteeringApp.encripty.PasswordUtil;
import com.example.volunteeringApp.entities.Clients;
import com.example.volunteeringApp.exceptions.EmailAlreadyExisteException;
import com.example.volunteeringApp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Clients> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Clients createClient(@RequestBody Clients client) {
        validateEmailUniqueness(client.getEmail());
        client.setPassword(PasswordUtil.encryptPassword(client.getPassword()));
        return clientRepository.save(client);
    }

    public void validateEmailUniqueness(String email) {
        if (clientRepository.existsByEmail(email)) {
            throw new EmailAlreadyExisteException("Email " + email + " já cadastrado");
        }
    }



}
