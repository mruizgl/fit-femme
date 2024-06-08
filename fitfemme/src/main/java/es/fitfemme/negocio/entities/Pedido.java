package es.fitfemme.negocio.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;
    private int id_usuario;
    private Date fecha_pedido;
    private float total;

    public Pedido() {
    }

    public Pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Pedido(int id_pedido, int id_usuario, Date fecha_pedido, float total) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.fecha_pedido = fecha_pedido;
        this.total = total;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id_pedido == pedido.id_pedido;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_pedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", id_usuario=" + id_usuario +
                ", fecha_pedido=" + fecha_pedido +
                ", total=" + total +
                '}';
    }
}
