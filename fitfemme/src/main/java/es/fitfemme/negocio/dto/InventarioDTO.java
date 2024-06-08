package es.fitfemme.negocio.dto;

import java.util.Objects;

public class InventarioDTO {
    private int id_producto;
    private int cantidad;

    public InventarioDTO() {
    }

    public InventarioDTO(int id_producto) {
        this.id_producto = id_producto;
    }

    public InventarioDTO(int id_producto, int cantidad) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventarioDTO that = (InventarioDTO) o;
        return id_producto == that.id_producto;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_producto);
    }

    @Override
    public String toString() {
        return "InventarioDTO{" +
                "id_producto=" + id_producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
