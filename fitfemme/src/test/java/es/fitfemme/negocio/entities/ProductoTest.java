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

    @Test
    public void constructorTest() {
        // Arrange
        int id_producto = 1;
        String nombre = "Producto Test";
        String descripcion = "Descripción del producto";
        float precio = 10.5f;
        Categoria categoria = new Categoria(1, "Categoria Test");

        // Act
        Producto producto = new Producto(id_producto, nombre, descripcion, precio, categoria);

        // Assert
        assertNotNull(producto);
        assertEquals(id_producto, producto.getId_producto());
        assertEquals(nombre, producto.getNombre());
        assertEquals(descripcion, producto.getDescripcion());
        assertEquals(precio, producto.getPrecio());
        assertEquals(categoria, producto.getCategoria());
    }

    @Test
    public void hashCodeTest() {
        // Arrange
        int id_producto = 1;
        Producto producto1 = new Producto(id_producto, "Producto1", "Descripción1", 10.5f, new Categoria(1, "Categoria1"));
        Producto producto2 = new Producto(id_producto, "Producto2", "Descripción2", 20.5f, new Categoria(2, "Categoria2"));

        // Act
        int hashCode1 = producto1.hashCode();
        int hashCode2 = producto2.hashCode();

        // Assert
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    public void toStringTest() {
        // Arrange
        Producto producto = new Producto(1, "Producto Test", "Descripción del producto", 10.5f, new Categoria(1, "Categoria Test"));

        // Act
        String result = producto.toString();

        // Assert
        assertNotNull(result);
        assertEquals("Producto{id_producto=1, nombre='Producto Test', descripcion='Descripción del producto', precio=10.5, id_categoria=1}", result);
    }



}
