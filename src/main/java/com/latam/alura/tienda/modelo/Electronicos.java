package com.latam.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "electronicos")

public class Electronicos extends Producto{
    private String marca;
    private String modelo;

    public Electronicos() {
    }

    public Electronicos(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
        super(nombre, descripcion, precio, categoria);
    }

    public Electronicos(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Electronicos(String nombre, String descripcion, BigDecimal precio, Categoria categoria, String marca, String modelo) {
        super(nombre, descripcion, precio, categoria);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
