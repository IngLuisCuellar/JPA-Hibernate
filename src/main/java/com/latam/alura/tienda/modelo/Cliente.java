package com.latam.alura.tienda.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Embedded //Inyección de la clase DatosPersonales
    private DatosPersonales datosPersonales;
    public Cliente() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Cliente(String nombre, String dni) {
        this.datosPersonales=new DatosPersonales(nombre, dni);
    }

    public Long getId() {
        return id;
    }

    public String getDni() {
        return datosPersonales.getDni(); //Delegamos la responsabilidada
    }

    public void setDni(String dni) {
        this.datosPersonales.setDni(dni);
    }

    public String getNombre() {
        return datosPersonales.getNombre();
    }

    public void setNombre(String nombre) {
        this.datosPersonales.setNombre(nombre);
    }
}
