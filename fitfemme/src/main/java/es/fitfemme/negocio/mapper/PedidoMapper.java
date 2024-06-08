package es.fitfemme.negocio.mapper;

import es.fitfemme.modelo.services.UsuarioService;
import es.fitfemme.negocio.dto.PedidoDTO;
import es.fitfemme.negocio.entities.Pedido;
import es.fitfemme.negocio.entities.Usuario;

public class PedidoMapper {

    public static PedidoDTO toDTO(Pedido pedido) {
        if (pedido == null) {
            return null;
        }
        UsuarioService usuarioService = new UsuarioService();


        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId_pedido(pedido.getId_pedido());
        pedidoDTO.setId_usuario(pedido.getId_usuario());
        Usuario usuario = usuarioService.obtenerUsuarioPorId(pedido.getId_usuario());
        pedidoDTO.setFecha_pedido(pedido.getFecha_pedido());
        pedidoDTO.setTotal(pedido.getTotal());
        pedidoDTO.setNombre_cliente(usuario.getNombre());
        pedidoDTO.setDireccion_cliente(usuario.getDireccion());

        return pedidoDTO;
    }

    public static Pedido toEntity(PedidoDTO pedidoDTO) {
        if (pedidoDTO == null) {
            return null;
        }

        Pedido pedido = new Pedido();
        pedido.setId_pedido(pedidoDTO.getId_pedido());
        pedido.setId_usuario(pedidoDTO.getId_usuario());
        pedido.setFecha_pedido(pedidoDTO.getFecha_pedido());
        pedido.setTotal(pedidoDTO.getTotal());

        return pedido;
    }
}
