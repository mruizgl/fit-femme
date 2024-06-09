package es.fitfemme.vista.repository;

import es.fitfemme.negocio.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
