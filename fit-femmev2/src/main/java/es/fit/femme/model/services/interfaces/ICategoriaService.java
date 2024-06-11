package es.fit.femme.model.services.interfaces;

import es.fit.femme.business.entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<Categoria> getAllObjects();
    Optional<Categoria> findById(Long id);
    void saveObject(Categoria categoria);
    void deleteObject(Long id);
}
