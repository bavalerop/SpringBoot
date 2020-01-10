package com.ciudad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "ciudad")
public class CiudadEntity {
	
	@Schema(description = "ID de los registros de la tabla de ciudades no recibe null", 
	example = "1", required = true)
	private int id;
	
	@Schema(description = "Nombre de los registros de la tabla de ciudades no recibe null", 
	example = "Bogota", required = true)
	private String nombre;
	
	public CiudadEntity() {
		this.id = 0;
		this.nombre = "";
	}
	
	public CiudadEntity(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	
	@Id
	@Column(name = "ciu_id", columnDefinition = "int", unique=true)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "ciu_nom", nullable = false, columnDefinition = "VARCHAR(50)")
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
