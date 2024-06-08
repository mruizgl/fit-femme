package es.fitfemme.negocio.entities;

import java.util.Objects;

public class Categoria {
    private int id_categoria;
    private String nombre;

    public Categoria() {
    }

    public Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Categoria(int id_categoria, String nombre) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id_categoria == categoria.id_categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_categoria);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_categoria=" + id_categoria +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}