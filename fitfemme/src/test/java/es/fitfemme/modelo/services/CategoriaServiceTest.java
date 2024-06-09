package es.fitfemme.modelo.services;

import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.vista.repository.ICategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoriaServiceTest {
    @Mock
    private ICategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllObjectsTest() {
        Categoria categoria1 = new Categoria();
        categoria1.setId_categoria(1);
        categoria1.setNombre("Categoria 1");

        Categoria categoria2 = new Categoria();
        categoria2.setId_categoria(2);
        categoria2.setNombre("Categoria 2");

        List<Categoria> categorias = Arrays.asList(categoria1, categoria2);
        when(categoriaRepository.findAll()).thenReturn(categorias);

        List<Categoria> result = categoriaService.getAllObjects();
        assertEquals(2, result.size());
        assertEquals("Categoria 1", result.get(0).getNombre());
        assertEquals("Categoria 2", result.get(1).getNombre());
    }

    @Test
    public void saveObjectTest() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Categoria Test");

        when(categoriaRepository.save(categoria)).thenReturn(categoria);

        Categoria result = categoriaService.saveObject(categoria);
        assertEquals("Categoria Test", result.getNombre());
    }

    @Test
    public void updateObjectTest() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Categoria Updated");

        when(categoriaRepository.save(categoria)).thenReturn(categoria);

        Categoria result = categoriaService.updateObject(categoria);
        assertEquals("Categoria Updated", result.getNombre());
    }

    @Test
    public void deleteObjectTest() {
        int id = 1;
        doNothing().when(categoriaRepository).deleteById(id);

        categoriaService.deleteObject(id);

        verify(categoriaRepository, times(1)).deleteById(id);
    }
}
