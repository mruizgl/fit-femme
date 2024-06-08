package es.fitfemme.negocio.mapper;

import es.fitfemme.negocio.dto.InventarioDTO;
import es.fitfemme.negocio.entities.Inventario;

public class InventarioMapper {
    public static InventarioDTO toDTO(Inventario inventario) {
        if (inventario == null) {
            return null;
        }

        InventarioDTO inventarioDTO = new InventarioDTO();
        inventarioDTO.setId_producto(inventario.getId_producto());
        inventarioDTO.setCantidad(inventario.getCantidad());

        return inventarioDTO;
    }

    public static Inventario toEntity(InventarioDTO inventarioDTO) {
        if (inventarioDTO == null) {
            return null;
        }

        Inventario inventario = new Inventario();
        inventario.setId_producto(inventarioDTO.getId_producto());
        inventario.setCantidad(inventarioDTO.getCantidad());

        return inventario;
    }
}
