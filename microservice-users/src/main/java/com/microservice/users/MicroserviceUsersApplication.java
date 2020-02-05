package com.microservice.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.microservice.users.entity")
@EnableJpaRepositories("com.microservice.users.repository") 
@SpringBootApplication (scanBasePackages = {"com.microservice.users"})
public class MicroserviceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUsersApplication.class, args);
	}

}
