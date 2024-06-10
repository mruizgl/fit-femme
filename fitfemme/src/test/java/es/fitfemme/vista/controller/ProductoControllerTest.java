package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.ProductoService;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllObjectsTest() {
        // Mock de la lista de productos
        List<Producto> productos = new ArrayList<>();
        // Agregar productos de prueba
        productos.add(new Producto(1, "Producto 1", "Descripción 1", 10.0f, new Categoria(1, "Categoria 1")));
        productos.add(new Producto(2, "Producto 2", "Descripción 2", 20.0f, new Categoria(2, "Categoria 2")));

        // Configurar el comportamiento esperado del servicio de productos
        when(productoService.getAllObjects()).thenReturn(productos);

        // Invocar al método del controlador y verificar el resultado
        List<Producto> result = productoController.getAllObjects();
        assertEquals(productos.size(), result.size());
    }



    @Test
    public void saveObjectTest() {
        // Mock de un producto de prueba
        Producto producto = new Producto(1, "Producto de prueba", "Descripción de prueba", 10.0f, new Categoria(1, "Categoria de prueba"));

        // Configurar el comportamiento esperado del servicio de productos
        when(productoService.saveObject(any(Producto.class))).thenReturn(producto);

        // Invocar al método del controlador y verificar el resultado
        ResponseEntity<Producto> response = productoController.saveObject(producto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(producto, response.getBody());
    }

    @Test
    public void updateObjectTest() {
        // Mock de un producto de prueba
        Producto producto = new Producto(1, "Producto de prueba", "Descripción de prueba", 10.0f, new Categoria(1, "Categoria de prueba"));

        // Configurar el comportamiento esperado del servicio de productos
        when(productoService.updateObject(any(Producto.class))).thenReturn(producto);

        // Invocar al método del controlador y verificar el resultado
        ResponseEntity<Producto> response = productoController.updateObject(1, producto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(producto, response.getBody());
    }

    @Test
    public void deleteObjectTest() {
        // Configurar el comportamiento esperado del servicio de productos
        doNothing().when(productoService).deleteObject(anyInt());

        // Invocar al método del controlador y verificar el resultado
        ResponseEntity<Void> response = productoController.deleteObject(1);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }



    @Test
    public void addProductoTest() {
        // Mock de un producto de prueba
        Producto producto = new Producto(1, "Producto de prueba", "Descripción de prueba", 10.0f, new Categoria(1, "Categoria de prueba"));

        // Configurar el comportamiento esperado del servicio de productos
        when(productoService.saveObject(any(Producto.class))).thenReturn(producto);

        // Invocar al método del controlador y verificar el resultado
        ResponseEntity<Producto> response = productoController.saveObject(producto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(producto, response.getBody());
    }

}