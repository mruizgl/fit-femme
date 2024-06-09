package es.fitfemme.modelo.services;

import es.fitfemme.negocio.entities.Pedido;
import es.fitfemme.vista.repository.IPedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class PedidoServiceTest {
    private SimpleDateFormat simpleDateFormat;

    @Mock
    private IPedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllObjectsTest() {
        Pedido pedido1 = new Pedido();
        pedido1.setId_pedido(1);
        pedido1.setId_usuario(1);
        pedido1.setFecha_pedido(new Date());
        pedido1.setTotal(100.0f);

        Pedido pedido2 = new Pedido();
        pedido2.setId_pedido(2);
        pedido2.setId_usuario(2);
        pedido2.setFecha_pedido(new Date());
        pedido2.setTotal(200.0f);

        List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);
        when(pedidoRepository.findAll()).thenReturn(pedidos);

        List<Pedido> result = pedidoService.getAllObjects();
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId_pedido());
        assertEquals(2, result.get(1).getId_pedido());
    }

    @Test
    public void saveObjectTest() {
        Pedido pedido = new Pedido();
        pedido.setId_usuario(1);
        pedido.setFecha_pedido(new Date());
        pedido.setTotal(100.0f);

        when(pedidoRepository.save(pedido)).thenReturn(pedido);

        Pedido result = pedidoService.saveObject(pedido);
        assertEquals(1, result.getId_usuario());
    }

    @Test
    public void updateObjectTest() {
        Pedido pedido = new Pedido();
        pedido.setId_pedido(1);
        pedido.setId_usuario(1);
        pedido.setFecha_pedido(new Date());
        pedido.setTotal(100.0f);

        when(pedidoRepository.save(pedido)).thenReturn(pedido);

        Pedido result = pedidoService.updateObject(pedido);
        assertEquals(1, result.getId_pedido());
    }

    @Test
    public void deleteObjectTest() {
        int id = 1;
        when(pedidoRepository.existsById(id)).thenReturn(true);

        pedidoService.deleteObject(id);

        verify(pedidoRepository, times(1)).deleteById(id);
    }

    @Test
    public void deleteObjectNotFoundTest() {
        int id = 1;
        when(pedidoRepository.existsById(id)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> pedidoService.deleteObject(id));
        assertEquals("Pedido no se puede borrar. No encontrado por el id " + id, exception.getMessage());
    }
}
