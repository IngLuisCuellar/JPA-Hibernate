package com.latam.alura.tienda.dao;

import com.latam.alura.tienda.modelo.Producto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductoDao {
    private EntityManager em;

    public ProductoDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Producto producto){
        this.em.persist(producto);
    }

    public Producto consultaPorId(Long id){
        return em.find(Producto.class, id);
    }

    public List<Producto> consultarTodos(){
        String jpql = "SELECT P FROM Producto AS P";

        return em.createQuery(jpql, Producto.class).getResultList();
    }
}
