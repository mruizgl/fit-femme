package es.fitfemme.negocio.mapper;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import es.fitfemme.negocio.dto.InventarioDTO;
import es.fitfemme.negocio.entities.Inventario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventarioMapperTest {
    private int id_producto = 15;
    private int cantidad = 20;
    private String MESSAGE_ERROR = "No se obtuvo el resultado esperado";

    @Test
    public void toDTOTest() {
        Inventario inventario = new Inventario();
        inventario.setId_producto(id_producto);
        inventario.setCantidad(cantidad);
        InventarioDTO inventarioDTO = InventarioMapper.toDTO(inventario);

        Assertions.assertEquals(id_producto, inventarioDTO.getId_producto(), MESSAGE_ERROR);
        Assertions.assertEquals(cantidad, inventarioDTO.getCantidad(), MESSAGE_ERROR);
        Assertions.assertNotNull(inventarioDTO);

    }

    @Test
    public void toEntityTest() {
        InventarioDTO inventarioDTO = new InventarioDTO();
        inventarioDTO.setId_producto(id_producto);
        inventarioDTO.setCantidad(cantidad);
        Inventario inventario = InventarioMapper.toEntity(inventarioDTO);

        Assertions.assertEquals(id_producto, inventario.getId_producto(), MESSAGE_ERROR);
        Assertions.assertEquals(cantidad, inventario.getCantidad(), MESSAGE_ERROR);
        Assertions.assertNotNull(inventario);

    }
}
