package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan("com.hotel.entity")
@EnableJpaRepositories("com.hotel.repository") 
@SpringBootApplication (scanBasePackages = {"com.hotel"})
public class HotelSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSpringBootApplication.class, args);
	}

}
