package es.fit.femme.model.services.impl;

import es.fit.femme.business.entities.Categoria;
import es.fit.femme.business.persistence.ICategoriaDao;
import es.fit.femme.model.services.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    ICategoriaDao categoriaDao;

    @Autowired
    public void setCategoriaService(ICategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }


    @Override
    public List<Categoria> getAllObjects() {
        return categoriaDao.getAllObjects();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaDao.findById(id);
    }

    @Override
    public void saveObject(Categoria categoria) {
        categoriaDao.saveObject(categoria);
    }

    @Override
    public void deleteObject(Long id) {
        categoriaDao.deleteObject(id);
    }
}
