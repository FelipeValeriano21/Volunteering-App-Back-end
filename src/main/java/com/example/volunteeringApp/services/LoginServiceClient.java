package com.example.volunteeringApp.services;

import com.example.volunteeringApp.entities.Clients;
import com.example.volunteeringApp.entities.LoginClient;
import com.example.volunteeringApp.exceptions.EmailAlreadyExisteException;
import com.example.volunteeringApp.exceptions.LoginErrorException;
import com.example.volunteeringApp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceClient {

    @Autowired
    private ClientRepository clientRepository;

    public LoginClient validateClient(LoginClient loginClient) {
        String email = loginClient.getEmail();
        String password = loginClient.getPassword();

        verifyEmptyInputs(email, password);
        boolean clientExists = clientRepository.existsByEmail(email);
        checkClientExistence(clientExists);

        Clients client = clientRepository.findByEmail(email);
        verifyPassword(client, password);

        return loginClient;
    }

    private void verifyEmptyInputs(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            throw new LoginErrorException("Email e senha são obrigatórios");
        }
    }

    private void checkClientExistence(boolean clientExists) {
        if (!clientExists) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
    }

    private void verifyPassword(Clients client, String password) {
        if (!client.getPassword().equals(password)) {
            throw new IllegalArgumentException("Senha incorreta");
        }
    }
}
