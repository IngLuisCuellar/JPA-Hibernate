package com.latam.alura.tienda.dao;

import com.latam.alura.tienda.modelo.Producto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Producto> consultaPorNombre(String nombre){
        String jpql = "SELECT P FROM Producto AS P WHERE P.nombre =: nombre";
        return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public  List<Producto> consultaPorNombreDeFCategoria(String nombre){
        String jpql = "SELECT P FROM Producto AS P WHERE P.categoria.nombre=:nombre";
        return  em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public BigDecimal consultaPrecioPorNombreDeProducto(String nombre){
        String jpql = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
        return em.createNamedQuery("Producto.consultaDePrecio", BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
    }

    public List<Producto> consultaPorParametro(String nombre, BigDecimal precio, LocalDate fecha){
        StringBuilder jpql = new StringBuilder("SELECT  p FROM Producto p WHERE 1=1 "); //Permite modificar el string
        if (nombre != null && !nombre.trim().isEmpty()) { //!nombre.trim().isEmpty() nombre que no sea vacio
            jpql.append("AND p.nombre=:nombre "); //Se va modificando la consulta a medida que se cumplan las condiciones
        }
        if (precio != null && !precio.equals(new BigDecimal(0))){
            jpql.append("AND p.precio=:precio ");
        }
        if (fecha != null){
            jpql.append("AND p.fechaDeRegistro=:fecha");
        }

        TypedQuery<Producto> query = em.createQuery(jpql.toString(), Producto.class);

        if (nombre != null && !nombre.trim().isEmpty()) { //!nombre.trim().isEmpty() nombre que no sea vacio
            query.setParameter("nombre", nombre);
        }
        if (precio != null && !precio.equals(new BigDecimal(0))){
            query.setParameter("precio", precio);
        }
        if (fecha != null){
            query.setParameter("fechaDeRegistro", fecha);
        }

        return query.getResultList();
    }
}
