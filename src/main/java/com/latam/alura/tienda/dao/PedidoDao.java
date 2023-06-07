package com.latam.alura.tienda.dao;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Pedido pedido){
        this.em.persist(pedido);
    }

    public Pedido consultaPorId(Long id){
        return em.find(Pedido.class, id);
    }

    public List<Pedido> consultarTodos(){
        String jpql = "SELECT P FROM Producto AS P";

        return em.createQuery(jpql, Pedido.class).getResultList();
    }

    public BigDecimal valorTotalVenta(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido AS p";
        return em.createQuery(jpql,BigDecimal.class).getSingleResult()  ;
    }

    public List<Object[]> relatorioDeVentas(){ //Devuelve arreglo de objetos, en lista
        String jpql = "SELECT producto.nombre, SUM(item.cantidad), MAX(pedido.fecha) FROM Pedido pedido " +
                "JOIN pedido.items item " +
                "JOIN item.producto producto " + //Se sigue el orden lógico de los campos, concatenandolos
                "GROUP BY producto.nombre " +
                "ORDER BY item.cantidad DESC"; //Ordena de forma descendente

        return em.createQuery(jpql,Object[].class).getResultList();
    }
}

