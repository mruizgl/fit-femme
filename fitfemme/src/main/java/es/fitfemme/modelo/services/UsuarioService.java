package es.fitfemme.modelo.services;

import es.fitfemme.negocio.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioPorId(int idUsuario) {

        return entityManager.find(Usuario.class, idUsuario);
    }
}
