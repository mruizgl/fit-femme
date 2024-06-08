package es.fitfemme.negocio.dto;

import java.util.Date;
import java.util.Objects;

public class PedidoDTO {
    private int id_pedido;
    private int id_usuario;
    private String nombre_cliente;
    private String direccion_cliente;
    private Date fecha_pedido;
    private float total;

    public PedidoDTO() {
    }

    public PedidoDTO(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public PedidoDTO(int id_pedido, int id_usuario, String nombre_cliente, String direccion_cliente, Date fecha_pedido, float total) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.nombre_cliente = nombre_cliente;
        this.direccion_cliente = direccion_cliente;
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

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
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
        PedidoDTO pedidoDTO = (PedidoDTO) o;
        return id_pedido == pedidoDTO.id_pedido;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_pedido);
    }

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "id_pedido=" + id_pedido +
                ", id_usuario=" + id_usuario +
                ", nombre_cliente='" + nombre_cliente + '\'' +
                ", direccion_cliente='" + direccion_cliente + '\'' +
                ", fecha_pedido=" + fecha_pedido +
                ", total=" + total +
                '}';
    }
}
