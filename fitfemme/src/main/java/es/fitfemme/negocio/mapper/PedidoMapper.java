package es.fitfemme.negocio.mapper;

import es.fitfemme.modelo.services.UsuarioService;
import es.fitfemme.negocio.dto.PedidoDTO;
import es.fitfemme.negocio.dto.UsuarioDTO;
import es.fitfemme.negocio.entities.Pedido;
import es.fitfemme.negocio.entities.Usuario;
import es.fitfemme.vista.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PedidoMapper {
    private static IUsuarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
        PedidoMapper.usuarioRepository = usuarioRepository;
    }

    public static PedidoDTO toDTO(Pedido pedido) {
        if (pedido == null) {
            return null;
        }

        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId_pedido(pedido.getId_pedido());
        pedidoDTO.setId_usuario(pedido.getId_usuario());
        pedidoDTO.setFecha_pedido(pedido.getFecha_pedido());
        pedidoDTO.setTotal(pedido.getTotal());


        return pedidoDTO;
    }

    public static Pedido toEntity(PedidoDTO pedidoDTO) {
        if (pedidoDTO == null) {
            return null;
        }

        Pedido pedido = new Pedido();
        pedido.setId_usuario(pedidoDTO.getId_usuario());
        pedido.setId_pedido(pedidoDTO.getId_pedido());
        pedido.setFecha_pedido(pedidoDTO.getFecha_pedido());
        pedido.setTotal(pedidoDTO.getTotal());

        return pedido;
    }
}
