package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.CategoriaService;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Producto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/categorias")
public class CategoriaController implements ICrudControllerJpa<Categoria>{
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    @Override
    public List<Categoria> getAllObjects() {
        return categoriaService.getAllObjects();
    }

    @PostMapping("/agregarCategoria")
    @Override
    public ResponseEntity<Categoria> saveObject(@RequestBody Categoria categoria) {
        Categoria savedCategoria = categoriaService.saveObject(categoria);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }


    @PutMapping("editar/{id}")
    @Override
    public ResponseEntity<Categoria> updateObject(@PathVariable int id, @RequestBody Categoria categoria) {
        categoria.setId_categoria(id);
        Categoria updatedCategoria = categoriaService.updateObject(categoria);
        return new ResponseEntity<>(updatedCategoria, HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    @Override
    public ResponseEntity<Void> deleteObject(@PathVariable int id) {
        categoriaService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
