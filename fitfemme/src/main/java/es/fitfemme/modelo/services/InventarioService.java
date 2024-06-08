package es.fitfemme.modelo.services;

import es.fitfemme.modelo.services.interfaces.ICrudServiceJpa;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Inventario;
import es.fitfemme.vista.repository.IInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventarioService implements ICrudServiceJpa<Inventario> {
    private IInventarioRepository inventarioRepository;

    @Autowired
    public void setInventarioRepository(IInventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public List<Inventario> getAllObjects() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario saveObject(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario updateObject(Inventario inventario) {
        if (inventarioRepository.existsById(inventario.getId_producto())) {
            return inventarioRepository.save(inventario);
        } else {
            throw new RuntimeException("Usuario no encontrado por el id  " + inventario.getId_producto());
        }
    }

    @Override
    public void deleteObject(int id) {
        if (inventarioRepository.existsById(id)) {
            inventarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado por el id  " + id);
        }
    }
}
