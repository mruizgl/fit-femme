package es.fitfemme.negocio.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
    @Test
    public void gettersAndSettersTest() {
        Producto producto = new Producto();
        producto.setId_producto(1);
        producto.setNombre("NombreProducto");
        producto.setDescripcion("DescripciónProducto");
        producto.setPrecio(10.5f);
        producto.setId_categoria(2);

        assertEquals(1, producto.getId_producto());
        assertEquals("NombreProducto", producto.getNombre());
        assertEquals("DescripciónProducto", producto.getDescripcion());
        assertEquals(10.5f, producto.getPrecio());
        assertEquals(1, producto.getId_categoria());
    }

    @Test
    public void equalsSameInstanceTest() {
        Producto producto1 = new Producto(1, "Nombre1", "Descripción1", 10.5f, 2);
        assertTrue(producto1.equals(producto1));
    }



    @Test
    public void equalsDifferentIdsTest() {
        Producto producto1 = new Producto(1, "Nombre1", "Descripción1", 10.5f, 2);
        Producto producto2 = new Producto(2, "Nombre2", "Descripción2", 20.5f, 3);
        assertFalse(producto1.equals(producto2));
    }

    @Test
    public void equalsNullTest() {
        Producto producto = new Producto(1, "Nombre1", "Descripción1", 10.5f, 2);
        assertFalse(producto.equals(null));
    }

    @Test
    public void equalsDifferentClassTest() {
        Producto producto = new Producto(1, "Nombre1", "Descripción1", 10.5f, 2);
        assertFalse(producto.equals(new Object()));
    }




}
