package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1l);
		System.out.println(producto.getNombre());
		
		List<Producto> productos = productoDao.consultarTodos();
		productos.forEach(prod -> System.out.println(prod.getDescripcion()));

	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULAR");
		Producto celular = new Producto("Samsung","Teléfono usado",new BigDecimal("1000"),celulares);

		EntityManager em = JPAUtils.getEntityManager();

		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);

		em.getTransaction().commit(); // This send the values to the DB
		em.close();
	}

}
