package com.example.volunteeringApp.controllers;

import com.example.volunteeringApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.volunteeringApp.entities.Clients;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "http://localhost:5173/Register")
    @PostMapping
    public Clients createClient(@RequestBody Clients client) {
        Clients result = clientService.addClient(client);
        return result;
    }

    @GetMapping
    public List<Clients> getAllClients() {
        List<Clients> result = clientService.getAllClients();
        return result;
    }

}
