package es.fitfemme.modelo.services;

import es.fitfemme.modelo.services.interfaces.ICrudServiceJpa;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Producto;
import es.fitfemme.vista.repository.ICategoriaRepository;
import es.fitfemme.vista.repository.IProductoRepository;
import es.fitfemme.vista.repository.IUsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CategoriaService implements ICrudServiceJpa<Categoria> {
    @Autowired
    private ICategoriaRepository categoriaRepository;


    @Override
    public List<Categoria> getAllObjects() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria saveObject(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateObject(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteObject(int id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return categoriaRepository.existsById(id);
    }


}
