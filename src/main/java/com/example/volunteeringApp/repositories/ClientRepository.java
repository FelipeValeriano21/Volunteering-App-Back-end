package com.example.volunteeringApp.repositories;
import com.example.volunteeringApp.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Clients, Long> {
    boolean existsById(Long id);
    boolean existsByEmail(String email);
    Clients findByEmail(String email);
}
