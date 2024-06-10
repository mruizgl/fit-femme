package es.fitfemme.modelo.services;

import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Producto;
import es.fitfemme.vista.repository.ICategoriaRepository;
import es.fitfemme.vista.repository.IProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProductoServiceTest {
    @Mock
    private IProductoRepository productoRepository;

    @Mock
    private ICategoriaRepository categoriaRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllObjectsTest() {
        Producto producto1 = new Producto();
        producto1.setId_producto(1);
        producto1.setNombre("Producto 1");
        producto1.setId_categoria(20);

        Producto producto2 = new Producto();
        producto2.setId_producto(2);
        producto2.setNombre("Producto 2");
        producto2.setId_categoria(6);

        List<Producto> productos = Arrays.asList(producto1, producto2);
        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> result = productoService.getAllObjects();
        assertEquals(2, result.size());
        assertEquals("Producto 1", result.get(0).getNombre());
        assertEquals("Producto 2", result.get(1).getNombre());
        assertEquals(20, result.get(1).getId_categoria());
    }

    @Test
    public void saveObjectTest() {
        Producto producto = new Producto();
        producto.setNombre("Nuevo Producto");

        when(productoRepository.save(producto)).thenReturn(producto);

        Producto result = productoService.saveObject(producto);
        assertEquals("Nuevo Producto", result.getNombre());
    }



    @Test
    public void SaveProductoTest() {
        Producto producto = new Producto();
        producto.setNombre("Nuevo Producto");

        Categoria categoria = new Categoria();
        categoria.setId_categoria(1);
        categoria.setNombre("Electrónicos");

        when(categoriaRepository.findById(1)).thenReturn(Optional.of(categoria));
        when(productoRepository.save(producto)).thenReturn(producto);

        Producto result = productoService.saveProducto(producto, 1);
        assertEquals("Nuevo Producto", result.getNombre());
        assertEquals(categoria, result.getCategoria());
    }


    @Test
    public void updateObjectTest() {
        Producto producto = new Producto();
        producto.setId_producto(123456); // Aquí establece el ID del producto que intentas actualizar
        producto.setNombre("Producto Actualizado");

        // Configura el mock del repositorio para que devuelva false al llamar a existsById
        when(productoRepository.existsById(producto.getId_producto())).thenReturn(false);

        // Llama al método updateObject y verifica que lance una RuntimeException
        RuntimeException exception = assertThrows(RuntimeException.class, () -> productoService.updateObject(producto));
        assertEquals("Producto no encontrado por el id  " + producto.getId_producto(), exception.getMessage());
    }

    @Test
    public void deleteObjectTest() {
        int id = 1;
        productoService.deleteObject(id);
        verify(productoRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateObject_ProductoEncontrado() {
        int idProducto = 123; // ID de ejemplo
        Producto producto = new Producto();
        producto.setId_producto(idProducto);

        // Simulamos que el producto existe en el repositorio
        when(productoRepository.existsById(idProducto)).thenReturn(true);

        // Llamamos al método updateObject
        productoService.updateObject(producto);

        // Verificamos que se haya llamado al método save del repositorio con el producto correcto
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    public void testUpdateObject_ProductoNoEncontrado() {
        int idProducto = 123; // ID de ejemplo
        Producto producto = new Producto();
        producto.setId_producto(idProducto);

        // Simulamos que el producto no existe en el repositorio
        when(productoRepository.existsById(idProducto)).thenReturn(false);

        // Verificamos que al llamar al método updateObject se lance una RuntimeException
        assertThrows(RuntimeException.class, () -> productoService.updateObject(producto));

        // Verificamos que no se haya llamado al método save del repositorio
        verify(productoRepository, never()).save(producto);
    }
}
