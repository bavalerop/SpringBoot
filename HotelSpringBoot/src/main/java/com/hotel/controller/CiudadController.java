package com.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;


@RestController
@RequestMapping("/api/hotel")
@Tag(name = "Hotel Controller", description = "Controlador para las ciudades que podran tener los hoteles")
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
	@GetMapping("/CiudadGetAll")
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
	@GetMapping("/CiudadByName/{name}")
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
	@GetMapping("/CiudadById/{id}")
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
	@ApiOperation(value = "Actualiza una ciudad", response = CiudadEntity.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Respuesta Exitosa", response = Object.class),
		@ApiResponse(code = 201, message = "Actualizado exitosamente", response = CiudadEntity.class),
		@ApiResponse(code = 204, message = "No se encontraron resultados", response = Object.class),
		@ApiResponse(code = 401, message = "No tiene autorización para ver el recurso", response = Object.class),
		@ApiResponse(code = 403, message = "Está prohibido acceder al recurso que estaba tratando de alcanzar", response = Object.class),
		@ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar", response = Object.class),
		@ApiResponse(code = 500, message = "Error de servidor", response = Object.class)
	})
	@ResponseBody 
	@PutMapping("/ActualizaCiudad")
	public ResponseEntity<?> update(
			@ApiParam(value = "Ciudad a Actualizar", required = true) @Valid @RequestBody CiudadEntity ciudad) throws Exception {
		if(ciuServ.Actualizar(ciudad)>0) {
			return new ResponseEntity<>(ciudad,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}		
	}
	
	//DELETE
	@ApiOperation(value = "Elimina una ciudad", response = CiudadEntity.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Respuesta Exitosa", response = Object.class),
		@ApiResponse(code = 201, message = "Eliminado exitosamente", response = CiudadEntity.class),
		@ApiResponse(code = 204, message = "No se encontraron resultados", response = Object.class),
		@ApiResponse(code = 401, message = "No tiene autorización para ver el recurso", response = Object.class),
		@ApiResponse(code = 403, message = "Está prohibido acceder al recurso que estaba tratando de alcanzar", response = Object.class),
		@ApiResponse(code = 404, message = "No se encuentra el recurso que intentabas alcanzar", response = Object.class),
		@ApiResponse(code = 500, message = "Error de servidor", response = Object.class)
	})
	@ResponseBody 
	@DeleteMapping("/EliminaCiudad/{id}")
	public ResponseEntity<?> delete(
			@ApiParam(value = "ID de la ciudad a eliminar", required = true)
			@PathVariable("id") int ciu_id
			)throws Exception {
		if(ciuServ.Borrar(ciu_id)>0) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}		
	}
	
	
	
	

}
