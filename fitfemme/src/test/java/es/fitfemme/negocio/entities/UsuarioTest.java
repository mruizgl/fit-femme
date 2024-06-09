package es.fitfemme.negocio.entities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    @Test
    public void equals_MismasInstanciasTest() {
        Usuario usuario1 = new Usuario(1, "Nombre", "email@example.com", "contrasenia", "Dirección");
        Usuario usuario2 = usuario1;

        assertTrue(usuario1.equals(usuario2));
        assertEquals(usuario1.hashCode(), usuario2.hashCode());
    }

    @Test
    public void equals_MismoIdTest() {
        Usuario usuario1 = new Usuario(1, "Nombre", "email@example.com", "contrasenia", "Dirección");
        Usuario usuario2 = new Usuario(1, "OtroNombre", "otroemail@example.com", "otracontrasenia", "OtraDirección");

        assertTrue(usuario1.equals(usuario2));
        assertEquals(usuario1.hashCode(), usuario2.hashCode());
    }

    @Test
    public void equals_DiferentesIdsTest() {
        Usuario usuario1 = new Usuario(1, "Nombre", "email@example.com", "contrasenia", "Dirección");
        Usuario usuario2 = new Usuario(2, "Nombre", "email@example.com", "contrasenia", "Dirección");

        assertFalse(usuario1.equals(usuario2));
        assertNotEquals(usuario1.hashCode(), usuario2.hashCode());
    }

    @Test
    public void equals_NullTest() {
        Usuario usuario1 = new Usuario(1, "Nombre", "email@example.com", "contrasenia", "Dirección");
        Usuario usuario2 = null;

        assertFalse(usuario1.equals(usuario2));
    }

    @Test
    public void equals_MismaClaseTest() {
        Usuario usuario1 = new Usuario(1, "Nombre", "email@example.com", "contrasenia", "Dirección");
        Object otroObjeto = new Object();

        assertFalse(usuario1.equals(otroObjeto));
    }

    @Test
    public void testToString() {
        Usuario usuario = new Usuario(1, "Nombre", "email@example.com", "contraseña", "Dirección");
        String expectedString = "Usuario{id_usuario=1, nombre='Nombre', email='email@example.com', contrasenia='contraseña', direccion='Dirección'}";
        assertEquals(expectedString, usuario.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Usuario usuario = new Usuario();
        Usuario usuario1 = new Usuario(1234);
        usuario.setId_usuario(1);
        usuario.setNombre("Nombre");
        usuario.setEmail("email@example.com");
        usuario.setContrasenia("contrasenia");
        usuario.setDireccion("Dirección");

        assertEquals(1, usuario.getId_usuario());
        assertEquals("Nombre", usuario.getNombre());
        assertEquals("email@example.com", usuario.getEmail());
        assertEquals("contrasenia", usuario.getContrasenia());
        assertEquals("Dirección", usuario.getDireccion());
        assertEquals(1234, usuario1.getId_usuario());
    }
}
