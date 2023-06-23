package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Producto;

public class RegistroDeProducto {

	public static void main(String[] args) {
		
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Teléfono usado");
		celular.setPrecio(new BigDecimal("1000"));

		// EntityManager is who are going to do the SQL commands
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		// This is an interface
		EntityManager em = factory.createEntityManager();
		// First of all, we need to tell to EntityManager that transactions are going to begin
		ProductoDao productoDao = new ProductoDao(em);
		
		em.getTransaction().begin();
		
		productoDao.guardar(celular);
		
		em.getTransaction().commit(); // This send the values to the DB
		
		em.clear();
	}

}
