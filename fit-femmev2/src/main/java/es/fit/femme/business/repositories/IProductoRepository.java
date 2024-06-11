package es.fit.femme.business.repositories;

import es.fit.femme.business.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {
}
