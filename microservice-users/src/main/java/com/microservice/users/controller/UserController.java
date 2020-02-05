package com.microservice.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.users.entity.UserEntity;
import com.microservice.users.service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController("/api/user")
@Tag(name = "UserEntity Controller", description = "Controlador para los usuarios")
public class UserController {

	@Autowired
	IUserService userService;

	//GET BY NAME
	@Operation(summary = "Get User By Name", description = "Muestra el usuario a buscar por nombre")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Respuesta Exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserEntity.class)))),
		@ApiResponse(responseCode = "201", description = "Creado exitosamente", content = @Content),
		@ApiResponse(responseCode = "204", description = "No se encontraron resultados", content = @Content),
		@ApiResponse(responseCode = "401", description = "No tiene autorización para ver el recurso", content = @Content),
		@ApiResponse(responseCode = "403", description = "Está prohibido acceder al recurso que estaba tratando de alcanzar", content = @Content),
		@ApiResponse(responseCode = "404", description = "No se encuentra el recurso que intentabas alcanzar", content = @Content),
		@ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content)
	})
	@GetMapping(value = "/getByName/{name}", produces = "application/json")
	public ResponseEntity<?> searchByName(
			@Parameter(description = "Nombre del usuario a buscar.") @PathVariable String name) throws Exception {
		List<UserEntity> listUser = userService.searchByName(name);
		if (listUser != null) {
			return new ResponseEntity<>(listUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

}
