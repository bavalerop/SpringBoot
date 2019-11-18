package com.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.entity.CiudadEntity;
import com.hotel.service.CiudadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "Controlador para las ciudades que podran tener los hoteles")
public class CiudadController {
	
	@Autowired
	private CiudadService ciuServ;
	
	//GET
	@ApiResponses({
		@ApiResponse(code = 200, message = "Respuesta Exitosa", response = CiudadEntity[].class),
		@ApiResponse(code = 201, message = "Creado exitosamente", response = Object.class),
		@ApiResponse(code = 204, message = "No se encontraron resultados", response = Object.class),
		@ApiResponse(code = 401, message = "No tiene autorización para ver el recurso", response = Object.class),
		@ApiResponse(code = 403, message = "Está prohibido acceder al recurso que estaba tratando de alcanzar", response = Object.class),
		@ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar", response = Object.class),
		@ApiResponse(code = 500, message = "Error de servidor", response = Object.class)
	})
	@ResponseBody 
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
	
	//GET BY NAME
	@ApiOperation(value = "Muestra la ciudad a buscar por nombre", response = List.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Respuesta Exitosa", response = CiudadEntity[].class),
		@ApiResponse(code = 201, message = "Creado exitosamente", response = Object.class),
		@ApiResponse(code = 204, message = "No se encontraron resultados", response = Object.class),
		@ApiResponse(code = 401, message = "No tiene autorización para ver el recurso", response = Object.class),
		@ApiResponse(code = 403, message = "Está prohibido acceder al recurso que estaba tratando de alcanzar", response = Object.class),
		@ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar", response = Object.class),
		@ApiResponse(code = 500, message = "Error de servidor", response = Object.class)
	})
	@GetMapping("/Ciudad/{name}")
	@ResponseBody 
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
	
	
	//GET BY ID
	@ApiOperation(value = "Muestra la ciudad a buscar por ID", response = List.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Respuesta Exitosa", response = CiudadEntity[].class),
		@ApiResponse(code = 201, message = "Creado exitosamente", response = Object.class),
		@ApiResponse(code = 204, message = "No se encontraron resultados", response = Object.class),
		@ApiResponse(code = 401, message = "No tiene autorización para ver el recurso", response = Object.class),
		@ApiResponse(code = 403, message = "Está prohibido acceder al recurso que estaba tratando de alcanzar", response = Object.class),
		@ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar", response = Object.class),
		@ApiResponse(code = 500, message = "Error de servidor", response = Object.class)
	})
	@GetMapping("/Ciudad/{id}")
	@ResponseBody 
	public ResponseEntity<?> findByID(
			@ApiParam(value = "ID de la ciudad a buscar", required = true)
			@PathVariable("id") int ciu_id
			)  throws Exception {
		List<CiudadEntity> listCiudades = ciuServ.BuscarId(ciu_id);
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
	
	//POST
	@ApiOperation(value = "Guarda una ciudad", response = CiudadEntity[].class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Respuesta Exitosa", response = Object.class),
		@ApiResponse(code = 201, message = "Creado exitosamente", response = CiudadEntity[].class),
		@ApiResponse(code = 204, message = "No se encontraron resultados", response = Object.class),
		@ApiResponse(code = 401, message = "No tiene autorización para ver el recurso", response = Object.class),
		@ApiResponse(code = 403, message = "Está prohibido acceder al recurso que estaba tratando de alcanzar", response = Object.class),
		@ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar", response = Object.class),
		@ApiResponse(code = 500, message = "Error de servidor", response = Object.class)
	})
	@ResponseBody 
	@PostMapping("/GuardarCiudad")
	public ResponseEntity<?> create(
			@ApiParam(value = "Ciudad a guardar", required = true) @Valid @RequestBody List<CiudadEntity> ciudades) throws Exception {
		ciuServ.Guardar(ciudades);
		return new ResponseEntity<>(ciudades,HttpStatus.CREATED);
	}
	
	//PUT
	@ApiOperation(value = "Actualiza una ciudad", response = CiudadEntity[].class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Respuesta Exitosa", response = Object.class),
		@ApiResponse(code = 201, message = "Actualizado exitosamente", response = CiudadEntity[].class),
		@ApiResponse(code = 204, message = "No se encontraron resultados", response = Object.class),
		@ApiResponse(code = 401, message = "No tiene autorización para ver el recurso", response = Object.class),
		@ApiResponse(code = 403, message = "Está prohibido acceder al recurso que estaba tratando de alcanzar", response = Object.class),
		@ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar", response = Object.class),
		@ApiResponse(code = 500, message = "Error de servidor", response = Object.class)
	})
	@ResponseBody 
	@PutMapping("/ActualizaCiudad")
	public ResponseEntity<?> update(
			@ApiParam(value = "Ciudades a Actualizar", required = true) @Valid @RequestBody List<CiudadEntity> ciudades) throws Exception {
		ciuServ.Guardar(ciudades);
		return new ResponseEntity<>(ciudades,HttpStatus.CREATED);
	}
	
	
	
	
	

}
