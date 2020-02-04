package com.hotel.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-ciudad", url="localhost:8082/api/ciudad") 
public interface CiudadRest {
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> findByID(@PathVariable int id);

}
