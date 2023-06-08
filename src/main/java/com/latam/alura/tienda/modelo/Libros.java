package com.latam.alura.tienda.modelo;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Libros extends Producto{
    private String autor;
    private int paginas;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public Libros() {
    }

    public Libros(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
        super(nombre, descripcion, precio, categoria);
    }

    public Libros(String autor, int paginas) {
        this.autor = autor;
        this.paginas = paginas;
    }

    public Libros(String nombre, String descripcion, BigDecimal precio, Categoria categoria, String autor, int paginas) {
        super(nombre, descripcion, precio, categoria);
        this.autor = autor;
        this.paginas = paginas;
    }
}
