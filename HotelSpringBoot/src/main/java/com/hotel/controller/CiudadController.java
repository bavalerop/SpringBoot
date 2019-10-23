package com.hotel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.entity.CiudadEntity;
import com.hotel.repository.interfaces.ICiudadRepo;


@RestController
@RequestMapping("/api")
public class CiudadController {

	@Autowired
	private ICiudadRepo repo;
	
	@PostMapping("/GuardarCiduad")
	public ResponseEntity<?> create(@RequestBody CiudadEntity ciudad) throws Exception {
		repo.save(ciudad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/Ciudad")
	public ResponseEntity<?> list() throws Exception {
		List<CiudadEntity> listCiudades = repo.findAll();
		if (listCiudades != null) {
			if (listCiudades.size() > 0) {
				return new ResponseEntity<>(listCiudades, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
}
