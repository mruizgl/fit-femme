package es.fitfemme.modelo.services;

import es.fitfemme.modelo.services.interfaces.ICrudServiceJpa;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Producto;
import es.fitfemme.vista.repository.ICategoriaRepository;
import es.fitfemme.vista.repository.IInventarioRepository;
import es.fitfemme.vista.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService implements ICrudServiceJpa<Producto> {
    private IProductoRepository productoRepository;


    @Autowired
    public void setProductoRepository(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllObjects() {
        return productoRepository.findAll();
    }

    @Override
    public Producto saveObject(Producto object) {
        return productoRepository.save(object);
    }


    public Producto saveProducto(Producto producto, int categoriaId) {

        return productoRepository.save(producto);
    }

    @Override
    public Producto updateObject(Producto producto) {
        if (!productoRepository.existsById(producto.getId_producto())) {
            throw new RuntimeException("Producto no encontrado por el id  " + producto.getId_producto());
        }
        return productoRepository.save(producto);
    }

    @Override
    public void deleteObject(int id) {
        productoRepository.deleteById(id);

    }

    public boolean existsById(int id) {
        return productoRepository.existsById(id);
    }


}
