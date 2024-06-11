package es.fit.femme.persistence.dao.interfaces;

import es.fit.femme.model.entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaDao {
    List<Categoria> getAllObjects();
    Optional<Categoria> findById(Long id);
    void saveObject(Categoria categoria);
    void deleteObject(Long id);
}
