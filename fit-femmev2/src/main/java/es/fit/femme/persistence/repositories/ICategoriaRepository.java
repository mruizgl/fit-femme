package es.fit.femme.persistence.repositories;

import es.fit.femme.model.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Long> {
}
