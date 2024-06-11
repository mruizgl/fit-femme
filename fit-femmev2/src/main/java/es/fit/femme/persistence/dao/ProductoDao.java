package es.fit.femme.persistence.dao;

import es.fit.femme.model.entities.Producto;
import es.fit.femme.persistence.dao.interfaces.IProductoDao;
import es.fit.femme.persistence.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ProductoDao implements IProductoDao {
    IProductoRepository productoRepository;

    @Autowired
    public void setProductoRepository(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    @Override
    public List<Producto> getAllObjects() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void saveObject(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteObject(Long id) {
        productoRepository.deleteById(id);
    }



}
