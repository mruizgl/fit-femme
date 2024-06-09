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
    public ResponseEntity saveObject(@RequestBody Producto producto) {
        Producto savedProducto = productoService.saveObject(producto);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity updateObject(@PathVariable int id, @RequestBody Producto producto) {
        producto.setId_producto(id);
        Producto updatedProducto = productoService.updateObject(producto);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteObject(@PathVariable int id) {
        productoService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public boolean existsById(int id) {
        return productoService.existsById(id);
    }

    @PostMapping("/agregarProducto")
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto, @RequestParam int categoriaId) {
        Producto nuevoProducto = productoService.saveProducto(producto, categoriaId);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

}
