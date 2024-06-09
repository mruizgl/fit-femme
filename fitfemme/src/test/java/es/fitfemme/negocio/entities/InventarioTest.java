package es.fitfemme.negocio.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {
    @Test
    public void constructorTest() {
        // Arrange
        int id_producto = 1;
        int cantidad = 10;

        // Act
        Inventario inventario = new Inventario(id_producto, cantidad);

        // Assert
        assertNotNull(inventario);
        assertEquals(id_producto, inventario.getId_producto());
        assertEquals(cantidad, inventario.getCantidad());
    }

    @Test
    public void equalsTest() {
        // Arrange
        Inventario inventario1 = new Inventario(1, 10);
        Inventario inventario2 = new Inventario(1, 20);
        Inventario inventario3 = new Inventario(2, 10);

        // Act & Assert
        assertEquals(inventario1, inventario2);
        assertNotEquals(inventario1, inventario3);
        assertNotEquals(inventario2, inventario3);
    }

    @Test
    public void hashCodeTest() {
        // Arrange
        Inventario inventario1 = new Inventario(1, 10);
        Inventario inventario2 = new Inventario(1, 20);

        // Act & Assert
        assertEquals(inventario1.hashCode(), inventario2.hashCode());
    }

    @Test
    public void toStringTest() {
        // Arrange
        Inventario inventario = new Inventario(1, 10);

        // Act
        String result = inventario.toString();

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("id_producto=1"));
        assertTrue(result.contains("cantidad=10"));
    }
}
