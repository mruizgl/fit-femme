package es.fit.femme.persistence.dao;

import es.fit.femme.model.entities.Categoria;
import es.fit.femme.persistence.dao.interfaces.ICategoriaDao;
import es.fit.femme.persistence.repositories.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class CategoriaDao implements ICategoriaDao {
    private ICategoriaRepository categoriaRepository;

    @Autowired
    public void setCategoriaRepository (ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public List<Categoria> getAllObjects() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void saveObject(Categoria categoria) {
        categoriaRepository.save(categoria);
    }


    @Override
    public void deleteObject(Long id) {
        categoriaRepository.deleteById(id);
    }
}
