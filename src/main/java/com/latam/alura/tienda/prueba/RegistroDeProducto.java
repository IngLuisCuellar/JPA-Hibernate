package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.dao.CategoriaDao;
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

        EntityManager em = JPAUtils.getEntityManager();

        em.getTransaction().begin(); //Señalamos el incio de las transacciones

        em.persist(celulares);

        celulares.setNombre("LIBROS");

        em.flush(); //Envia a la BD permitiendo el rollback de los valores

        em.clear(); //Cambia el estado a detached, pero no la cierra

        celulares = em.merge(celulares); //Es necesario hacer un merge de la entidad que se va modificar, reasignandolo asi mismo
        // para ello se hacen los constructores por defecto

        celulares.setNombre("SOFTWARES");

        em.flush();
    }
}
