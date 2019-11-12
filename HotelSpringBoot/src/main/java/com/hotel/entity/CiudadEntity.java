package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ciudad")
@ApiModel(description = "Tabla de las ciudades para los hoteles")
public class CiudadEntity {
	

	@ApiModelProperty(notes = "ID de los registros de la tabla de ciudades no recibe null")
	private int id;
	
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
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ciu_id", updatable = false, nullable = false, columnDefinition = "int")
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
		return "CiudadEntity [id=" + id + ", nombre=" + nombre + "]";
	}

}
