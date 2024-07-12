package com.example.volunteeringApp.services;

import com.example.volunteeringApp.entities.Clients;
import com.example.volunteeringApp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Clients addClient(@RequestBody Clients client) {
        return clientRepository.save(client);

    }

    public List<Clients> getAllClients() {
        return clientRepository.findAll();
    }

}
