package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.CategoriaService;
import es.fitfemme.modelo.services.InventarioService;
import es.fitfemme.modelo.services.ProductoService;
import es.fitfemme.negocio.entities.Producto;
import es.fitfemme.negocio.entities.Usuario;
import es.fitfemme.vista.repository.IInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/productos")
public class ProductoController implements ICrudControllerJpa<Producto> {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    @Override
    public List getAllObjects() {
        return productoService.getAllObjects();
    }

    @PostMapping("/")
    @Override
    public ResponseEntity saveObject(Producto producto) {
        Producto savedProducto = productoService.saveObject(producto);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity updateObject(int id, Producto producto) {
        producto.setId_producto(id);
        Producto updatedProducto = productoService.updateObject(producto);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    }

    @DeleteMapping
    @Override
    public ResponseEntity<Void> deleteObject(int id) {
        productoService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
