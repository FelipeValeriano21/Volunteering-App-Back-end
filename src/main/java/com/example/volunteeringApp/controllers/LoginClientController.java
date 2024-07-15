package com.example.volunteeringApp.controllers;

import com.example.volunteeringApp.entities.Clients;
import com.example.volunteeringApp.entities.LoginClient;
import com.example.volunteeringApp.services.LoginServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginClientController {

    @Autowired
    LoginServiceClient loginServiceClient;

    @CrossOrigin(origins = "http://localhost:5173/Login")
    @PostMapping
    public LoginClient createClient(@RequestBody LoginClient loginclient) {
        LoginClient result = loginServiceClient.validateClient(loginclient);
        return result;
    }


}
