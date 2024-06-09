package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.PedidoService;
import es.fitfemme.negocio.entities.Pedido;
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
public class PedidoControllerTest {

    @Mock
    private PedidoService pedidoService;

    @InjectMocks
    private PedidoController pedidoController;

    @Test
    public void getAllObjectsTest() {
        // Arrange
        List<Pedido> pedidoList = new ArrayList<>();
        // Agregando algunos pedidos de ejemplo a la lista...
        pedidoList.add(new Pedido());
        pedidoList.add(new Pedido());

        when(pedidoService.getAllObjects()).thenReturn(pedidoList);

        // Act
        List<Pedido> result = pedidoController.getAllObjects();

        // Assert
        assertEquals(pedidoList.size(), result.size());
        verify(pedidoService, times(1)).getAllObjects();
    }

    @Test
    public void saveObjectTest() {
        // Arrange
        Pedido pedido = new Pedido();
        // Simulando la llamada al método del servicio...
        when(pedidoService.saveObject(pedido)).thenReturn(pedido);

        // Act
        ResponseEntity<Pedido> responseEntity = pedidoController.saveObject(pedido);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(pedido, responseEntity.getBody());
        verify(pedidoService, times(1)).saveObject(pedido);
    }

    @Test
    public void updateObjectTest() {
        // Arrange
        int id = 1;
        Pedido pedido = new Pedido();
        pedido.setId_pedido(id);
        // Simulando la llamada al método del servicio...
        when(pedidoService.updateObject(pedido)).thenReturn(pedido);

        // Act
        ResponseEntity<Pedido> responseEntity = pedidoController.updateObject(id, pedido);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(pedido, responseEntity.getBody());
        verify(pedidoService, times(1)).updateObject(pedido);
    }

    @Test
    public void deleteObjectTest() {
        // Arrange
        int id = 1;

        // Act
        ResponseEntity<Void> responseEntity = pedidoController.deleteObject(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(pedidoService, times(1)).deleteObject(id);
    }
}
