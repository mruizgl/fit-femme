package es.fitfemme.modelo.services;

import es.fitfemme.modelo.services.interfaces.ICrudServiceJpa;
import es.fitfemme.negocio.entities.Pedido;
import es.fitfemme.vista.controller.ICrudControllerJpa;
import es.fitfemme.vista.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoService implements ICrudServiceJpa<Pedido> {
    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllObjects() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido saveObject(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido updateObject(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteObject(int id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        }else {
            throw new RuntimeException("Pedido no se puede borrar. No encontrado por el id " + id);
        }
    }
}
