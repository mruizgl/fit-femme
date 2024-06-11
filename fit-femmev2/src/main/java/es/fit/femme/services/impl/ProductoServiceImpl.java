package es.fit.femme.services.impl;

import es.fit.femme.model.entities.Producto;
import es.fit.femme.persistence.IProductoDao;
import es.fit.femme.services.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoServiceImpl implements IProductoService {
    private IProductoDao productoDao;

    @Autowired
    public void setProductoDao (IProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    @Override
    public List<Producto> getAllObjects() {
        return productoDao.getAllObjects();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoDao.findById(id);
    }

    @Override
    public void saveObject(Producto producto) {
        productoDao.saveObject(producto);
    }

    @Override
    public void deleteObject(Long id) {
        productoDao.deleteObject(id);
    }

}
