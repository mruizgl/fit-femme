package es.fitfemme.modelo.services;

import es.fitfemme.modelo.services.interfaces.ICrudServiceJpa;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.vista.repository.ICategoriaRepository;
import es.fitfemme.vista.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaService implements ICrudServiceJpa<Categoria> {
    private ICategoriaRepository categoriaRepository;

    @Autowired
    public void setCategoriaRepository(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

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
        if (categoriaRepository.existsById(categoria.getId_categoria())) {
            return categoriaRepository.save(categoria);
        } else {
            throw new RuntimeException("Usuario no encontrado por el id  " + categoria.getId_categoria());
        }
    }

    @Override
    public void deleteObject(int id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado por el id  " + id);
        }
    }
}
