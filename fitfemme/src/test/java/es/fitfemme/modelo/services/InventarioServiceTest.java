package es.fitfemme.modelo.services;

import es.fitfemme.negocio.entities.Inventario;
import es.fitfemme.vista.repository.IInventarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InventarioServiceTest {
    @Mock
    private IInventarioRepository inventarioRepository;

    @InjectMocks
    private InventarioService inventarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllObjectsTest() {
        Inventario inventario1 = new Inventario();
        inventario1.setId_producto(1);
        inventario1.setCantidad(10);

        Inventario inventario2 = new Inventario();
        inventario2.setId_producto(2);
        inventario2.setCantidad(20);

        List<Inventario> inventarios = Arrays.asList(inventario1, inventario2);
        when(inventarioRepository.findAll()).thenReturn(inventarios);

        List<Inventario> result = inventarioService.getAllObjects();
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId_producto());
        assertEquals(10, result.get(0).getCantidad());
        assertEquals(2, result.get(1).getId_producto());
        assertEquals(20, result.get(1).getCantidad());
    }

    @Test
    public void saveObjectTest() {
        Inventario inventario = new Inventario();
        inventario.setId_producto(1);
        inventario.setCantidad(10);

        when(inventarioRepository.save(inventario)).thenReturn(inventario);

        Inventario result = inventarioService.saveObject(inventario);
        assertEquals(1, result.getId_producto());
        assertEquals(10, result.getCantidad());
    }

    @Test
    public void updateObjectTest() {
        Inventario inventario = new Inventario();
        inventario.setId_producto(1);
        inventario.setCantidad(20);

        when(inventarioRepository.existsById(inventario.getId_producto())).thenReturn(true);
        when(inventarioRepository.save(inventario)).thenReturn(inventario);

        Inventario result = inventarioService.updateObject(inventario);
        assertEquals(1, result.getId_producto());
        assertEquals(20, result.getCantidad());
    }

    @Test
    public void updateObjectNotFoundTest() {
        Inventario inventario = new Inventario();
        inventario.setId_producto(1);
        inventario.setCantidad(20);

        when(inventarioRepository.existsById(inventario.getId_producto())).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> inventarioService.updateObject(inventario));
        assertEquals("Usuario no encontrado por el id  " + inventario.getId_producto(), exception.getMessage());
    }

    @Test
    public void deleteObjectTest() {
        int id = 1;
        when(inventarioRepository.existsById(id)).thenReturn(true);

        inventarioService.deleteObject(id);

        verify(inventarioRepository, times(1)).deleteById(id);
    }

    @Test
    public void deleteObjectNotFoundTest() {
        int id = 1;
        when(inventarioRepository.existsById(id)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> inventarioService.deleteObject(id));
        assertEquals("Usuario no encontrado por el id  " + id, exception.getMessage());
    }
}
