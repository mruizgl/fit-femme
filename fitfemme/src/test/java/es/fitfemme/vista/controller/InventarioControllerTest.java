package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.InventarioService;
import es.fitfemme.negocio.entities.Inventario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InventarioControllerTest {

    @Mock
    private InventarioService inventarioService;

    @InjectMocks
    private InventarioController inventarioController;

    @Test
    public void getAllObjectsTest() {
        // Arrange
        List<Inventario> inventarioList = new ArrayList<>();
        // Adding some dummy inventario objects to the list...
        inventarioList.add(new Inventario());
        inventarioList.add(new Inventario());

        when(inventarioService.getAllObjects()).thenReturn(inventarioList);

        // Act
        List<Inventario> result = inventarioController.getAllObjects();

        // Assert
        assertEquals(inventarioList.size(), result.size());
        verify(inventarioService, times(1)).getAllObjects();
    }

    @Test
    public void saveObjectTest() {
        // Arrange
        Inventario inventario = new Inventario();
        // Mocking the service method call...
        when(inventarioService.updateObject(inventario)).thenReturn(inventario);

        // Act
        ResponseEntity<Inventario> responseEntity = inventarioController.saveObject(inventario);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(inventario, responseEntity.getBody());
        verify(inventarioService, times(1)).updateObject(inventario);
    }

    @Test
    public void updateObjectTest() {
        // Arrange
        int id = 1;
        Inventario inventario = new Inventario();
        inventario.setId_producto(id);
        // Mocking the service method call...
        when(inventarioService.updateObject(inventario)).thenReturn(inventario);

        // Act
        ResponseEntity<Inventario> responseEntity = inventarioController.updateObject(id, inventario);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(inventario, responseEntity.getBody());
        verify(inventarioService, times(1)).updateObject(inventario);
    }

    @Test
    public void deleteObjectTest() {
        // Arrange
        int id = 1;

        // Act
        ResponseEntity<Void> responseEntity = inventarioController.deleteObject(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(inventarioService, times(1)).deleteObject(id);
    }
}
