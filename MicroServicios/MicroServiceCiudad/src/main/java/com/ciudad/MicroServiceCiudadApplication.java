package com.ciudad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan("com.ciudad.entity")
@EnableJpaRepositories("com.ciudad.repository") 
@SpringBootApplication (scanBasePackages = {"com.ciudad"})
public class MicroServiceCiudadApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCiudadApplication.class, args);
	}

}
