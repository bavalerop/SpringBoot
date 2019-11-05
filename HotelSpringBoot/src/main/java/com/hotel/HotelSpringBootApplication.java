package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"com.hotel"})
public class HotelSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSpringBootApplication.class, args);
	}

}
