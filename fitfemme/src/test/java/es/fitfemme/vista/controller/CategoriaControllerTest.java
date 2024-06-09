package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.CategoriaService;
import es.fitfemme.negocio.entities.Categoria;
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
public class CategoriaControllerTest {

    @Mock
    private CategoriaService categoriaService;

    @InjectMocks
    private CategoriaController categoriaController;

    @Test
    public void getAllObjectsTest() {
        // Arrange
        List<Categoria> categoriaList = new ArrayList<>();
        // Adding some dummy categoria objects to the list...
        categoriaList.add(new Categoria());
        categoriaList.add(new Categoria());

        when(categoriaService.getAllObjects()).thenReturn(categoriaList);

        // Act
        List<Categoria> result = categoriaController.getAllObjects();

        // Assert
        assertEquals(categoriaList.size(), result.size());
        verify(categoriaService, times(1)).getAllObjects();
    }

    @Test
    public void saveObjectTest() {
        // Arrange
        Categoria categoria = new Categoria();
        // Mocking the service method call...
        when(categoriaService.saveObject(categoria)).thenReturn(categoria);

        // Act
        ResponseEntity<Categoria> responseEntity = categoriaController.saveObject(categoria);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(categoria, responseEntity.getBody());
        verify(categoriaService, times(1)).saveObject(categoria);
    }

    @Test
    public void updateObjectTest() {
        // Arrange
        int id = 1;
        Categoria categoria = new Categoria();
        categoria.setId_categoria(id);
        // Mocking the service method call...
        when(categoriaService.updateObject(categoria)).thenReturn(categoria);

        // Act
        ResponseEntity<Categoria> responseEntity = categoriaController.updateObject(id, categoria);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(categoria, responseEntity.getBody());
        verify(categoriaService, times(1)).updateObject(categoria);
    }

    @Test
    public void deleteObjectTest() {
        // Arrange
        int id = 1;

        // Act
        ResponseEntity<Void> responseEntity = categoriaController.deleteObject(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(categoriaService, times(1)).deleteObject(id);
    }
}
