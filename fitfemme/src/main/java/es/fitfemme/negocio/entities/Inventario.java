package es.fitfemme.negocio.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    public Inventario() {
    }

    public Inventario(int id_producto, int cantidad) {
        this.idProducto = id_producto;
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return idProducto;
    }

    public void setId_producto(int id_producto) {
        this.idProducto = id_producto;
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
        Inventario that = (Inventario) o;
        return idProducto == that.idProducto;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idProducto);
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id_producto=" + idProducto +
                ", cantidad=" + cantidad +
                '}';
    }
}
