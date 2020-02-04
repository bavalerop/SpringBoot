package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "hotel")
public class HotelEntity {
	
	@Schema(description = "ID de los registros de la tabla de hoteles no recibe null", 
	example = "1", required = true)
	private int id;
	
	@Schema(description = "Nombre de los registros de la tabla de hoteles no recibe null", 
	example = "Decameron", required = true)
	private String nombre;
	
	@Schema(description = "ID de la tabla ciudad la cual corresponde a la ciudad donde se encuentra el hotel", 
	example = "1", required = true)
	private int ciu_id;
	
	@Schema(description = "Direccion donde se encuentra el hotel", 
	example = "Calle falsa 123", required = true)
	private String direccion;
	
	@Schema(description = "Numero de habitaciones del hotel", 
	example = "8", required = true)
	private int numHab;
	
	
	private CiudadModel ciudad;

	public HotelEntity(int id, String nombre, int ciu_id, String direccion, int numHab, CiudadModel ciudad) {
		this.id = id;
		this.nombre = nombre;
		this.ciu_id = ciu_id;
		this.direccion = direccion;
		this.numHab = numHab;
		this.ciudad = ciudad;
	}

	public HotelEntity() {
	}

	@Id
	@Column(name = "hot_nit", columnDefinition = "int", unique=true)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "hot_nom", nullable = false, columnDefinition = "VARCHAR(50)")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "hot_ciu", nullable = false, columnDefinition = "int")
	public int getCiu_id() {
		return ciu_id;
	}

	public void setCiu_id(int ciu_id) {
		this.ciu_id = ciu_id;
	}

	@Column(name = "hot_dir", nullable = false, columnDefinition = "VARCHAR(80)")
	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "hot_numh", nullable = false, columnDefinition = "int")
	public int getNumHab() {
		return numHab;
	}


	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	public CiudadModel getCiudad() {
		return ciudad;
	}


	public void setCiudad(CiudadModel ciudad) {
		this.ciudad = ciudad;
	}

	

	@Override
	public String toString() {
		return "HotelEntity [id=" + id + ", nombre=" + nombre + ", ciu_id=" + ciu_id + ", direccion=" + direccion
				+ ", numHab=" + numHab + ", ciudad=" + ciudad + "]";
	}
	

}
