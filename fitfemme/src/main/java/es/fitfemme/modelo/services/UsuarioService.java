package es.fitfemme.modelo.services;

import es.fitfemme.modelo.services.interfaces.ICrudServiceJpa;
import es.fitfemme.negocio.entities.Usuario;
import es.fitfemme.vista.repository.IUsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements ICrudServiceJpa<Usuario> {
    private IUsuarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllObjects() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario saveObject(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateObject(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getId_usuario())) {
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario no encontrado por el id  " + usuario.getId_usuario());
        }
    }

    @Override
    public void deleteObject(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado por el id  " + id);
        }

    }

    @Override
    public Usuario getObjectById(int id) {
        return usuarioRepository.findById(id);
    }

}
