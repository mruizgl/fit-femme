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
    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public List<Producto> getAllObjects() {
        return productoRepository.findAll();
    }

    @Override
    public Producto saveObject(Producto object) {
        return productoRepository.save(object);
    }


    public Producto saveProducto(Producto producto, int categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria not found"));

        // Establecer la relación entre Producto y Categoria
        producto.setCategoria(categoria);
        categoria.addProducto(producto);

        // Guardar la categoría y el producto
        categoriaRepository.save(categoria); // Se asegura de que la relación se guarde correctamente
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


}
