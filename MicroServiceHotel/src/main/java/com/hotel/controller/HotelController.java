package com.hotel.controller;

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
import com.hotel.entity.HotelEntity;
import com.hotel.service.IHotelService;
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
@Tag(name = "Hotel Controller", description = "Controlador para las hoteles")
public class HotelController {
	
	@Autowired
	private IHotelService hotServ;
	
	
		//GET
		@Operation(summary = "Get Hoteles", description = "Muestra la lista de Hoteles")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelEntity.class)))),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@GetMapping(value = "/getAll", produces = "application/json")
		public ResponseEntity<?> list() throws Exception {
			List<HotelEntity> listHoteles = hotServ.Todos();
			if (listHoteles != null) {
				return new ResponseEntity<>(listHoteles, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}
		
		//GET BY NAME
		@Operation(summary = "Get Hotel By Name", description = "Muestra el hotel a buscar por nombre")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelEntity.class)))),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@GetMapping(value = "/getByName/{name}", produces = "application/json")
		@ResponseBody 
		public ResponseEntity<?> findByName(
				@Parameter(description="Nombre del hotel a buscar.")
				@PathVariable String name
				)  throws Exception {
			List<HotelEntity> listHoteles = hotServ.BuscarNombre(name);
			if (listHoteles != null) {
				return new ResponseEntity<>(listHoteles, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}
		
		
		//GET BY ID
		@Operation(summary = "Get Hotel By ID", description = "Muestra el hotel a buscar por ID")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelEntity.class)))),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@GetMapping(value = "/getById/{id}", produces = "application/json")
		@ResponseBody 
		public ResponseEntity<?> findByID(
				@Parameter(description="ID del hotel a buscar.")
				@PathVariable int id
				)  throws Exception {
			HotelEntity hotel = hotServ.BuscarId(id);
			if (hotel != null) {
				return new ResponseEntity<>(hotel, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}
		
		//POST
		@Operation(summary = "Post Hotel", description = "Guarda el hotel ingresado")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelEntity.class)))),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@PostMapping(value = "/save", produces = "application/json")
		public ResponseEntity<?> create(
				@Parameter(description="Hotel a guardar.", required=true)  @RequestBody HotelEntity hotel) throws Exception {
			try {
				return new ResponseEntity<>(hotServ.Guardar(hotel), HttpStatus.CREATED);
			}catch(Exception e) {
				/*FALTA EL LOG (Cuando es bad request el front devuelve error img personalizado)*/
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
		}
		
		//POST
		@Operation(summary = "Post Hoteles", description = "Guarda la lista de hoteles ingresada")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content),
			@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelEntity.class)))),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@PostMapping(value = "/saveList", produces = "application/json")
		public ResponseEntity<?> create(
				@Parameter(description="Hoteles a guardar.", required=true)  @RequestBody List<HotelEntity> hoteles) throws Exception {
			try {
				return new ResponseEntity<>(hotServ.GuardarBloque(hoteles),HttpStatus.CREATED);
			}catch(Exception e) {
				/*FALTA EL LOG (Cuando es bad request el front devuelve error img personalizado)*/
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
		}
		
		//PUT
		@Operation(summary = "Put Hotel", description = "Actualiza el hotel ingresado")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content),
			@ApiResponse(responseCode = "201", description = "Actualizado exitosamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelEntity.class)))),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@PutMapping(value = "/update", produces = "application/json")
		public ResponseEntity<?> update(
				@Parameter(description="Hotel a Actualizar.", required=true)  @RequestBody HotelEntity Hotel) throws Exception {
				HotelEntity Hotelr = hotServ.Actualizar(Hotel);
				if (Hotelr != null) {
					return new ResponseEntity<>(Hotelr, HttpStatus.OK);
				} else {
					return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
				}

		}
		
		//DELETE
		@Operation(summary = "Delete Hotel By ID", description = "Elimina el hotel ingresado por ID")
		@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content),
			@ApiResponse(responseCode = "201", description = "Eliminado exitosamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelEntity.class)))),
			@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
			@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
			@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
		})
		@ResponseBody 
		@DeleteMapping(value = "/delete/{id}", produces = "application/json")
		public ResponseEntity<?> delete(
				@Parameter(description="ID del hotel a eliminar.")
				@PathVariable int id
				)throws Exception {
			if(hotServ.Borrar(id)>0) {	
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}		
		}
	

}
