package es.fit.femme.persistence;

import es.fit.femme.model.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoDao {
    List<Producto> getAllObjects();
    Optional<Producto> findById(Long id);
    void saveObject(Producto producto);
    void deleteObject(Long id);
}
