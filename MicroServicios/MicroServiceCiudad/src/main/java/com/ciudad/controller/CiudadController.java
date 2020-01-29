package com.ciudad.controller;

import java.util.List;
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
import com.ciudad.entity.CiudadEntity;
import com.ciudad.service.ICiudadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;

@RestController
@RequestMapping("/api/ciudad")
@Tag(name = "Ciudad Controller", description = "Controlador para las ciudades")
public class CiudadController {
	
	@Autowired
	private ICiudadService ciuServ;
	
	
		//GET
		@Operation(summary = "Get Ciudad", description = "Muestra la lista de ciudades")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CiudadEntity.class)))),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@GetMapping(value = "/", produces = "application/json")
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
		@Operation(summary = "Get Ciudad By Name", description = "Muestra la ciudad a buscar por nombre")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CiudadEntity.class)))),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@GetMapping(value = "/{name}", produces = "application/json")
		@ResponseBody 
		public ResponseEntity<?> findByName(
				@Parameter(description="Nombre de la ciudad a buscar.")
				@PathVariable String name
				)  throws Exception {
			List<CiudadEntity> listCiudades = ciuServ.BuscarNombre(name);
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
		@Operation(summary = "Get Ciudad By ID", description = "Muestra la ciudad a buscar por ID")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CiudadEntity.class)))),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@GetMapping(value = "/{id}", produces = "application/json")
		@ResponseBody 
		public ResponseEntity<?> findByID(
				@Parameter(description="ID de la ciudad a buscar.")
				@PathVariable int id
				)  throws Exception {
			CiudadEntity ciudad = ciuServ.BuscarId(id);
			if (ciudad != null) {
				return new ResponseEntity<>(ciudad, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}
		
		//POST
		@Operation(summary = "Post Ciudad", description = "Guarda la ciudad ingresada")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CiudadEntity.class)))),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@PostMapping(value = "/", produces = "application/json")
		public ResponseEntity<?> create(
				@Parameter(description="Ciudad a guardar.", required=true)  @RequestBody CiudadEntity ciudad) throws Exception {
			return new ResponseEntity<>(ciuServ.Guardar(ciudad),HttpStatus.CREATED);
		}
		
		//POST
		@Operation(summary = "Post Ciudades", description = "Guarda la lista de ciudades ingresada")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CiudadEntity.class)))),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@PostMapping(value = "/guardarList", produces = "application/json")
		public ResponseEntity<?> create(
				@Parameter(description="Ciudad a guardar.", required=true)  @RequestBody List<CiudadEntity> ciudades) throws Exception {
			return new ResponseEntity<>(ciuServ.GuardarBloque(ciudades),HttpStatus.CREATED);
		}
		
		//PUT
		@Operation(summary = "Put Ciudad", description = "Actualiza la ciudad ingresada")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content),
			@ApiResponse(responseCode = "201", description = "Actualizado exitosamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CiudadEntity.class)))),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@PutMapping(value = "/", produces = "application/json")
		public ResponseEntity<?> update(
				@Parameter(description="Ciudad a Actualizar.", required=true)  @RequestBody CiudadEntity ciudad) throws Exception {
				return new ResponseEntity<>(ciuServ.Actualizar(ciudad), HttpStatus.CREATED);	
		}
		
		//DELETE
		@Operation(summary = "Delete Ciudad By ID", description = "Elimina la ciudad ingresada por ID")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content),
			@ApiResponse(responseCode = "201", description = "Eliminado exitosamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CiudadEntity.class)))),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@DeleteMapping(value = "/{id}", produces = "application/json")
		public ResponseEntity<?> delete(
				@Parameter(description="ID de la ciudad a eliminar.")
				@PathVariable int id
				)throws Exception {
			if(ciuServ.Borrar(id)>0) {	
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}		
		}
	

}
