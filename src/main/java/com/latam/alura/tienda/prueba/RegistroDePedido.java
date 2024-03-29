package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ClienteDao;
import com.latam.alura.tienda.dao.PedidoDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.*;
import com.latam.alura.tienda.utils.JPAUtils;
import com.latam.alura.tienda.vo.RelatorioDeVenta;
import net.bytebuddy.asm.MemberSubstitution;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class RegistroDePedido {
    public static void main(String[] args) {
        RegistarProducto();

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDao productoDao = new ProductoDao(em);
        Producto producto = productoDao.consultaPorId(1l);

        ClienteDao clienteDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);


        Cliente cliente = new Cliente("Juan", "1235");
        Pedido pedido = new Pedido(cliente);

        pedido.agregarItems(new ItemsPedido(5, producto, pedido));

        em.getTransaction().begin();
        clienteDao.guardar(cliente);
        pedidoDao.guardar(pedido);
        em.getTransaction().commit();

        BigDecimal valorTotal = pedidoDao.valorTotalVenta();
        System.out.println("Valor total "+ valorTotal);

        List<RelatorioDeVenta> relatorio = pedidoDao.relatorioDeVentasVO();

        relatorio.forEach(System.out::println);
    }

    private static void RegistarProducto() {
        Categoria celulares = new Categoria("CELULARES");

        Producto celular = new Producto("Xiaomi Redmi", "Muy legal", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDao.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
