package com.latam.alura.tienda.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha = LocalDate.now();
    private BigDecimal valorTotal = new BigDecimal(0);

    @ManyToOne(fetch=FetchType.LAZY) //Estrategia de cargamiento, los llama unicamente cuando sean solicitados
    //Por defecto todos son EAGER, es decir, con un cargamiento anticipado
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) //Al hacer una acción en pedido, hace la acción en cascada, itemPedido
    private List<ItemsPedido> items = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarItems(ItemsPedido item){ //Agregar item en la lista
        item.setPedido(this); //Se pasa ESTE pedido
        this.items.add(item);
        this.valorTotal = this.valorTotal.add(item.getValor());
    }

    public Pedido() {
    }
}
