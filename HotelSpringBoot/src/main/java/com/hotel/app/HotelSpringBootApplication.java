package com.hotel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.hotel")
public class HotelSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSpringBootApplication.class, args);
	}

}
