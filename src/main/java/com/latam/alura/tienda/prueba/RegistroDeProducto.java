package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria(    "CELULARES");
        Producto celular = new Producto("Smnsung", "Telefono usado", new BigDecimal("1000"),
                celulares);

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDao productoDao = new ProductoDao(em);

        em.getTransaction().begin(); //Señalamos el incio de las transacciones

        productoDao.guardar(celular);

        em.getTransaction().commit(); //Envia los valores de la instancia a la BD

        em.close(); //Cerramos la entidad
    }
}
