package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.CategoriaService;
import es.fitfemme.modelo.services.InventarioService;
import es.fitfemme.modelo.services.ProductoService;
import es.fitfemme.modelo.services.dto.ProductoDTO;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Producto;
import es.fitfemme.negocio.entities.Usuario;
import es.fitfemme.vista.repository.IInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/productos")
public class ProductoController implements ICrudControllerJpa<Producto> {
    private ProductoService productoService;
    private CategoriaService categoriaService;

    @Autowired
    public void setProductoService (ProductoService productoService) {
        this.productoService = productoService;
    }

    @Autowired
    public void setCategoriaService(CategoriaService categoriaService)  {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    @Override
    public List getAllObjects() {
        return productoService.getAllObjects();
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<Producto> saveObject(Producto object) {
        productoService.saveObject(object);
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
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




}
