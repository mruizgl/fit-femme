package es.fitfemme.vista.repository;

import es.fitfemme.negocio.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}
