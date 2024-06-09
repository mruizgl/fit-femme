package es.fitfemme.negocio.entities;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {

    @Test
    public void constructorTest() {
        // Arrange
        int id_categoria = 1;

        // Act
        Categoria categoria = new Categoria(id_categoria);

        // Assert
        assertNotNull(categoria);
        assertEquals(id_categoria, categoria.getId_categoria());
    }

    @Test
    public void equalsTest() {
        // Arrange
        Categoria categoria1 = new Categoria(1);
        Categoria categoria2 = new Categoria(1);
        Categoria categoria3 = new Categoria(2);

        // Act & Assert
        assertEquals(categoria1, categoria2);
        assertNotEquals(categoria1, categoria3);
        assertNotEquals(categoria2, categoria3);
    }

    @Test
    public void hashCodeTest() {
        // Arrange
        Categoria categoria1 = new Categoria(1);
        Categoria categoria2 = new Categoria(1);

        // Act & Assert
        assertEquals(categoria1.hashCode(), categoria2.hashCode());
    }

    @Test
    public void toStringTest() {
        // Arrange
        Categoria categoria = new Categoria(1);
        categoria.setNombre("Nombre de la categoria");

        // Act
        String result = categoria.toString();

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("id_categoria=1"));
        assertFalse(result.contains("nombre=Nombre"));
    }

    @Test
    public void addProductoTest() {
        // Arrange
        Categoria categoria = new Categoria(1);
        Producto producto = new Producto(1, "Producto 1", "Descripción", 10.5f, categoria);

        // Act
        categoria.addProducto(producto);

        // Assert
        assertTrue(categoria.getProductos().contains(producto));
        assertEquals(categoria, producto.getCategoria());
    }

    @Test
    public void removeProductoTest() {
        // Arrange
        Categoria categoria = new Categoria(1);
        Producto producto = new Producto(1, "Producto 1", "Descripción", 10.5f, categoria);
        categoria.addProducto(producto);

        // Act
        categoria.removeProducto(producto);

        // Assert
        assertTrue(categoria.getProductos().isEmpty());
        assertNull(producto.getCategoria());
    }
}
