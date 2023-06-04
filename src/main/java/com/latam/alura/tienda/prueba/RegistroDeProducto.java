package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.modelo.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {
        Producto celular = new Producto();
        celular.setNombre("Samnsung");
        celular.setDescripcion("Telefono usado");
        celular.setPrecio(new BigDecimal("1000"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda"); //Permite crear valores/interfaces dentro de esta clase
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin(); //Señalamos el incio de las transacciones

        em.persist(celular); //Crea una persistencia

        em.getTransaction().commit(); //Envia los valores de la instancia a la BD

        em.close(); //Cerramos la entidad
    }
}
