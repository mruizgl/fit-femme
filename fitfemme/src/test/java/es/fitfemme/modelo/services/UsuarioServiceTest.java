package es.fitfemme.modelo.services;

import es.fitfemme.negocio.entities.Usuario;
import es.fitfemme.vista.repository.IUsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UsuarioServiceTest {
    @Mock
    private IUsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllObjectsTest() {
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        List<Usuario> expectedUsuarios = Arrays.asList(usuario1, usuario2);
        when(usuarioRepository.findAll()).thenReturn(expectedUsuarios);
        List<Usuario> actualUsuarios = usuarioService.getAllObjects();
        Assertions.assertEquals(expectedUsuarios, actualUsuarios);
    }

    @Test
    public void saveObjectTest() {
        Usuario usuario = new Usuario();
        when(usuarioRepository.save(usuario)).thenReturn(usuario);
        Usuario savedUsuario = usuarioService.saveObject(usuario);
        Assertions.assertEquals(usuario, savedUsuario);
    }
    @Test
    public void testUpdateObject() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setId_usuario(1);

        when(usuarioRepository.existsById(1)).thenReturn(true);
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        // Act
        Usuario updatedUsuario = usuarioService.updateObject(usuario);

        // Assert
        Assertions.assertEquals(usuario, updatedUsuario);
    }

    @Test
    public void testUpdateObject_UsuarioNoExiste() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setId_usuario(1);

        when(usuarioRepository.existsById(1)).thenReturn(false);

        // Act/Assert
        assertThrows(RuntimeException.class, () -> {
            usuarioService.updateObject(usuario);
        });
    }



    @Test
    public void testDeleteObject_UsuarioNoExiste() {
        // Arrange
        int id = 1;

        when(usuarioRepository.existsById(id)).thenReturn(false);

        // Act/Assert
        assertThrows(RuntimeException.class, () -> {
            usuarioService.deleteObject(id);
        });
    }


}
