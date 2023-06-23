package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULAR");
		Categoria newCallToCelulares = new Categoria("CELULAR");
	
		EntityManager em = JPAUtils.getEntityManager();
				
		em.getTransaction().begin();
		
		em.persist(celulares);
		celulares.setNombre("LIBROS");
		
		em.flush();
		em.clear();
		
		newCallToCelulares = em.merge(celulares);
		newCallToCelulares.setNombre("SOFTWARES");
		em.flush();
		em.clear();
		
		newCallToCelulares = em.merge(newCallToCelulares);
		em.remove(newCallToCelulares);
		em.flush();
		
	}

}
