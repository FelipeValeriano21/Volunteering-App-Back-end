package com.example.volunteeringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableTransactionManagement

public class VolunteeringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VolunteeringAppApplication.class, args);
	}

}
