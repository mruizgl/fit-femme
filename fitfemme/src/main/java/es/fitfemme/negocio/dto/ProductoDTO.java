package es.fitfemme.negocio.dto;

import java.util.Objects;

public class ProductoDTO {
    private int id_producto;
    private String nombre;
    private String descripcion;
    private float precio;
    private int id_categoria;

    public ProductoDTO() {
    }

    public ProductoDTO(int id_producto) {
        this.id_producto = id_producto;
    }

    public ProductoDTO(int id_producto, String nombre, String descripcion, float precio, int id_categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.id_categoria = id_categoria;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoDTO that = (ProductoDTO) o;
        return id_producto == that.id_producto;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_producto);
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "id_producto=" + id_producto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", id_categoria=" + id_categoria +
                '}';
    }
}
