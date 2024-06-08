package es.fitfemme.vista.repository;

import es.fitfemme.negocio.entities.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventarioRepository extends JpaRepository <Inventario, Integer> {
}
