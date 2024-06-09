package es.fitfemme.vista.repository;

import es.fitfemme.negocio.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
    boolean existsById(int id);
}
