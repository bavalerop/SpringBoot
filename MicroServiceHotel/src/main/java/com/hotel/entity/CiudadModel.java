package com.hotel.entity;

import io.swagger.v3.oas.annotations.media.Schema;


public class CiudadModel {
	
	@Schema(description = "ID de los registros de la tabla de ciudades no recibe null", 
	example = "1", required = true)
	private int id;
	
	@Schema(description = "Nombre de los registros de la tabla de ciudades no recibe null", 
	example = "Bogota", required = true)
	private String nombre;
	
	public CiudadModel() {
		this.id = 0;
		this.nombre = "";
	}
	
	public CiudadModel(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "{id=" + id  + ", nombre=" + nombre + "}";
	}

}
