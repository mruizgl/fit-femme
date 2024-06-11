package es.fit.femme.business.repositories;

import es.fit.femme.business.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Long> {
}
