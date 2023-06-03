package com.latam.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity  //Anotación que nos indica que esta es una entidad que realiza mapeamientos
@Table(name = "productos") //Esta anotaciòn permite poner el nombre de representación en la tabla

public class Producto {
    private long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

}
