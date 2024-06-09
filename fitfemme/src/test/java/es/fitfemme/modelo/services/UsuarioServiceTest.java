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
import static org.mockito.Mockito.*;


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
    public void deleteObject_UsuarioNoExisteTest() {
        // Arrange
        int id = 1;

        when(usuarioRepository.existsById(id)).thenReturn(false);

        // Act/Assert
        assertThrows(RuntimeException.class, () -> {
            usuarioService.deleteObject(id);
        });
    }

    @Test
    public void deleteObject_UsuarioEncontradoTest() {
        int id = 123; // ID de ejemplo
        // Simulamos que el usuario existe en el repositorio
        when(usuarioRepository.existsById(id)).thenReturn(true);

        // Llamamos al método deleteObject
        usuarioService.deleteObject(id);

        // Verificamos que se haya llamado al método deleteById del repositorio con el ID correcto
        verify(usuarioRepository, times(1)).deleteById(id);
    }

    @Test
    public void deleteObject_UsuarioNoEncontradoTest() {
        int id = 123; // ID de ejemplo
        // Simulamos que el usuario no existe en el repositorio
        when(usuarioRepository.existsById(id)).thenReturn(false);

        // Verificamos que al llamar al método deleteObject se lance una RuntimeException
        assertThrows(RuntimeException.class, () -> usuarioService.deleteObject(id));

        // Verificamos que no se haya llamado al método deleteById del repositorio
        verify(usuarioRepository, never()).deleteById(id);
    }

}
