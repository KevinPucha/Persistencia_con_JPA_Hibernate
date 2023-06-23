package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")

public class Producto {
	
	@Id //Indicate that this is the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indicate that the responsability of generate the Id is of the DB and not from the user 
	private Long id;
	@Column(name="nombre") // Changing the name of the below column
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private LocalDate fechaDeRegistro = LocalDate.now();
	private Categoria categoria;
	
	public Producto () {
	}
	public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public BigDecimal getPrecio() {
		return precio;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
}
