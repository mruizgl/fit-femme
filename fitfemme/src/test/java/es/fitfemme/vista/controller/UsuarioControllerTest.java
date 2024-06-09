package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.UsuarioService;
import es.fitfemme.negocio.entities.Usuario;
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
public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    public void getAllObjectsTest() {
        // Arrange
        List<Usuario> usuarioList = new ArrayList<>();
        // Adding some dummy usuario objects to the list...
        usuarioList.add(new Usuario());
        usuarioList.add(new Usuario());

        when(usuarioService.getAllObjects()).thenReturn(usuarioList);

        // Act
        List<Usuario> result = usuarioController.getAllObjects();

        // Assert
        assertEquals(usuarioList.size(), result.size());
        verify(usuarioService, times(1)).getAllObjects();
    }

    @Test
    public void saveObjectTest() {
        // Arrange
        Usuario usuario = new Usuario();
        // Mocking the service method call...
        when(usuarioService.saveObject(usuario)).thenReturn(usuario);

        // Act
        ResponseEntity<Usuario> responseEntity = usuarioController.saveObject(usuario);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(usuario, responseEntity.getBody());
        verify(usuarioService, times(1)).saveObject(usuario);
    }

    @Test
    public void updateObjectTest() {
        // Arrange
        int id = 1;
        Usuario usuario = new Usuario();
        usuario.setId_usuario(id);
        // Mocking the service method call...
        when(usuarioService.updateObject(usuario)).thenReturn(usuario);

        // Act
        ResponseEntity<Usuario> responseEntity = usuarioController.updateObject(id, usuario);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(usuario, responseEntity.getBody());
        verify(usuarioService, times(1)).updateObject(usuario);
    }

    @Test
    public void deleteObjectTest() {
        // Arrange
        int id = 1;

        // Act
        ResponseEntity<Void> responseEntity = usuarioController.deleteObject(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(usuarioService, times(1)).deleteObject(id);
    }
}

