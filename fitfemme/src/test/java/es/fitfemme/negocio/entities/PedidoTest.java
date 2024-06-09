package es.fitfemme.negocio.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoTest {

    @Test
    public void constructorTest() {
        // Arrange
        int id_pedido = 1;
        int id_usuario = 2;
        Date fecha_pedido = new Date();
        float total = 100.0f;

        // Act
        Pedido pedido = new Pedido(id_pedido, id_usuario, fecha_pedido, total);

        // Assert
        assertNotNull(pedido);
        assertEquals(id_pedido, pedido.getId_pedido());
        assertEquals(id_usuario, pedido.getId_usuario());
        assertEquals(fecha_pedido, pedido.getFecha_pedido());
        assertEquals(total, pedido.getTotal());
    }

    @Test
    public void equalsTest() {
        // Arrange
        Pedido pedido1 = new Pedido(1);
        Pedido pedido2 = new Pedido(1);
        Pedido pedido3 = new Pedido(2);

        // Act & Assert
        assertEquals(pedido1, pedido2);
        assertNotEquals(pedido1, pedido3);
        assertNotEquals(pedido2, pedido3);
    }

    @Test
    public void hashCodeTest() {
        // Arrange
        Pedido pedido1 = new Pedido(1);
        Pedido pedido2 = new Pedido(1);

        // Act & Assert
        assertEquals(pedido1.hashCode(), pedido2.hashCode());
    }

    @Test
    public void toStringTest() {
        // Arrange
        int id_pedido = 1;
        int id_usuario = 2;
        Date fecha_pedido = new Date();
        float total = 100.0f;

        Pedido pedido = new Pedido(id_pedido, id_usuario, fecha_pedido, total);

        // Act
        String result = pedido.toString();

        // Assert
        assertNotNull(result);
        assertEquals("Pedido{id_pedido=1, id_usuario=2, fecha_pedido=" + fecha_pedido + ", total=100.0}", result);
    }
}
