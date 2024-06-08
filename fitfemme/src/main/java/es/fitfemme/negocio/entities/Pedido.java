package es.fitfemme.negocio.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "Pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int idPedido;

    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "fecha_pedido")
    private Date fechaPedido;

    @Column(name = "total")
    private float total;

    public Pedido() {
    }

    public Pedido(int id_pedido) {
        this.idPedido = id_pedido;
    }

    public Pedido(int id_pedido, int id_usuario, Date fecha_pedido, float total) {
        this.idPedido = id_pedido;
        this.idUsuario = id_usuario;
        this.fechaPedido = fecha_pedido;
        this.total = total;
    }

    public int getId_pedido() {
        return idPedido;
    }

    public void setId_pedido(int id_pedido) {
        this.idPedido = id_pedido;
    }

    public int getId_usuario() {
        return idUsuario;
    }

    public void setId_usuario(int id_usuario) {
        this.idUsuario = id_usuario;
    }

    public Date getFecha_pedido() {
        return fechaPedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fechaPedido = fecha_pedido;
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
        return idPedido == pedido.idPedido;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + idPedido +
                ", id_usuario=" + idUsuario +
                ", fecha_pedido=" + fechaPedido +
                ", total=" + total +
                '}';
    }
}
