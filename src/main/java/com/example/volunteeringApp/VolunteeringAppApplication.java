package com.example.volunteeringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class VolunteeringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VolunteeringAppApplication.class, args);
	}

}
