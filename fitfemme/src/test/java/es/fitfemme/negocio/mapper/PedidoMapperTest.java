package es.fitfemme.negocio.mapper;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import es.fitfemme.negocio.dto.PedidoDTO;
import es.fitfemme.negocio.entities.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoMapperTest {
    private int id_pedido = 1;
    private int id_usuario = 1;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date fecha_pedido;

    {
        try {
            fecha_pedido = simpleDateFormat.parse("16/03/1997");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private float total = 10;
    private String MESSAGE_ERROR = "No se obtuvo el resultado esperado";

    @Test
    public void toDTOTest() {
        Pedido pedido = new Pedido();
        pedido.setId_pedido(id_pedido);
        pedido.setId_usuario(id_usuario);
        pedido.setFecha_pedido(fecha_pedido);
        pedido.setTotal(total);

        PedidoDTO pedidoDTO = PedidoMapper.toDTO(pedido);
        Assertions.assertNotNull(pedidoDTO);
        Assertions.assertEquals(id_pedido, pedidoDTO.getId_pedido(), MESSAGE_ERROR);
        Assertions.assertEquals(id_usuario, pedidoDTO.getId_usuario(), MESSAGE_ERROR);
        Assertions.assertEquals(fecha_pedido, pedidoDTO.getFecha_pedido(), MESSAGE_ERROR);
        Assertions.assertEquals(total, pedidoDTO.getTotal(), MESSAGE_ERROR);
    }

    @Test
    public void toEntity() {
        PedidoDTO pedidoDTO= new PedidoDTO();
        pedidoDTO.setId_pedido(id_pedido);
        pedidoDTO.setId_usuario(id_usuario);
        pedidoDTO.setFecha_pedido(fecha_pedido);
        pedidoDTO.setTotal(total);

        Pedido pedido = PedidoMapper.toEntity(pedidoDTO);
        Assertions.assertNotNull(pedido, MESSAGE_ERROR);
        Assertions.assertEquals(id_usuario, pedido.getId_usuario(), MESSAGE_ERROR);
        Assertions.assertEquals(id_pedido, pedido.getId_pedido(), MESSAGE_ERROR);
        Assertions.assertEquals(fecha_pedido, pedido.getFecha_pedido(), MESSAGE_ERROR);
        Assertions.assertEquals(total, pedido.getTotal(), MESSAGE_ERROR);
    }
}
