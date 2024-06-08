package es.fitfemme.negocio.dto;

import java.util.Objects;

public class CategoriaDTO {
    private int id_categoria;
    private String nombre;
    private int total_productos_categoria;


    public CategoriaDTO() {
    }
    public CategoriaDTO(int id_categoria) {
        this.id_categoria = id_categoria;
    }


    public CategoriaDTO(int id_categoria, String nombre, int total_productos_categoria) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.total_productos_categoria = total_productos_categoria;
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

    public int getTotal_productos_categoria() {
        return total_productos_categoria;
    }

    public void setTotal_productos_categoria(int total_productos_categoria) {
        this.total_productos_categoria = total_productos_categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaDTO that = (CategoriaDTO) o;
        return id_categoria == that.id_categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_categoria);
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "id_categoria=" + id_categoria +
                ", nombre='" + nombre + '\'' +
                ", total_productos_categoria=" + total_productos_categoria +
                '}';
    }
}
