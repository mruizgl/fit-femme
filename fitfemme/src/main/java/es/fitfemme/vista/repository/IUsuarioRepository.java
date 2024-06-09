package es.fitfemme.vista.repository;

import es.fitfemme.negocio.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsById(int id);
}
