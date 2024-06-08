package es.fitfemme.negocio.dto;

public class ProductoDTO {
    private int id_producto;
    private String nombre;
    private String descripcion;
    private float precio;
    private int id_categoria;
    private int inventario_disponible;

    public ProductoDTO() {
    }

    public ProductoDTO(int id_producto) {
        this.id_producto = id_producto;
    }

    public ProductoDTO(int id_producto, String nombre, String descripcion, float precio, int id_categoria, int inventario_disponible) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.id_categoria = id_categoria;
        this.inventario_disponible = inventario_disponible;
    }
}
