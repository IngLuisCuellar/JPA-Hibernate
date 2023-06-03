package com.latam.alura.tienda.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity  //Anotación que nos indica que esta es una entidad que realiza mapeamientos
@Table(name = "productos") //Esta anotaciòn permite poner el nombre de representación de la tabla Nombre tabla, nombre clase

public class Producto {

    @Id //Identificador del Id de la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Se genera en la base de datos según el tipo
    private long id;
    //@Column(name = "Si tuvieran un nombre diferente")
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}