package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ciudad")

@ApiModel(description = "Tabla de las ciudades para los hoteles")
public class CiudadEntity {
	
	@Id
	@Column(name = "ciu_id", updatable = false, nullable = false, columnDefinition = "int")
	@ApiModelProperty(notes = "ID de los registros de la tabla de ciudades no recibe null")
	private int id;
	@Column(name = "ciu_nom", nullable = false, columnDefinition = "VARCHAR(50)")
	@ApiModelProperty(notes = "Nombre de los registros de la tabla de ciudades no recibe null")
	private String nombre;
	
	public CiudadEntity() {
		this.id = 0;
		this.nombre = "";
	}
	
	public CiudadEntity(int id, String nombre) {
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
		return "CiudadEntity [id=" + id + ", nombre=" + nombre + "]";
	}

}
