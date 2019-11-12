package com.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.entity.CiudadEntity;
import com.hotel.service.CiudadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api")
@Api(value = "Controlador para las ciudades que podran tener los hoteles")
public class CiudadController {
	
	@Autowired
	private CiudadService ciuServ;
	
	@ApiOperation(value = "Guarda una ciudad", response = List.class)
	@PostMapping("/GuardarCiudad")
	public ResponseEntity<?> create(
			@ApiParam(value = "Ciudad a guardar", required = true) @Valid @RequestBody CiudadEntity ciudad) throws Exception {
		ciuServ.Guardar(ciudad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@ApiOperation(value = "Muestra la lista de ciudades", response = List.class)
	@GetMapping("/Ciudad")
	public ResponseEntity<?> list() throws Exception {
		List<CiudadEntity> listCiudades = ciuServ.Todos();
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
	
	@ApiOperation(value = "Muestra la ciudad a buscar por nombre", response = List.class)
	@ApiResponse(code = 204, message = "No se encontraron resultados", response = Object.class)
	@GetMapping("/Ciudad/{name}")
	public ResponseEntity<?> findByName(
			@ApiParam(value = "Nombre de la ciudad a buscar", required = true)
			@PathVariable("name") String ciu_name
			)  throws Exception {
		List<CiudadEntity> listCiudades = ciuServ.BuscarNombre(ciu_name);
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
