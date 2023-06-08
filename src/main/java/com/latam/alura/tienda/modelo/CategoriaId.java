package com.latam.alura.tienda.modelo;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CategoriaId implements Serializable { //Todos los emmbedable deben implementarla
    private String nombre;
    private String contrasenha;

    public CategoriaId(String nombre, String contrasenha) {
        this.nombre = nombre;
        this.contrasenha = contrasenha;
    }

    public CategoriaId() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        CategoriaId other = (CategoriaId) o;
        if(nombre == null){
            if(other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (contrasenha == null){
            if(other.contrasenha != null)
                return false;
        } else if (!contrasenha.equals(other.contrasenha))
            return false;
        return true;
    }

}
