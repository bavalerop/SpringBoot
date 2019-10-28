package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
public class CiudadEntity {

	@Id
	@Column(name = "ciu_id", updatable = false, nullable = false, columnDefinition = "int")
	private int id;
	@Column(name = "ciu_nom", nullable = true, columnDefinition = "VARCHAR(50)")
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

}
