package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.CategoriaService;
import es.fitfemme.modelo.services.InventarioService;
import es.fitfemme.modelo.services.interfaces.ICrudServiceJpa;
import es.fitfemme.negocio.entities.Categoria;
import es.fitfemme.negocio.entities.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/inventario")
public class InventarioController implements ICrudControllerJpa<Inventario> {
    private InventarioService inventarioService;

    @Autowired
    public void setInventarioInventario(InventarioService inventarioService) {
        this.inventarioService=inventarioService;
    }


    @GetMapping("/")
    @Override
    public List<Inventario> getAllObjects() {
        return inventarioService.getAllObjects();
    }

    @PostMapping("/{id}")
    @Override
    public ResponseEntity<Inventario> saveObject(Inventario inventario) {
        Inventario savedInventario = inventarioService.updateObject(inventario);
        return new ResponseEntity<>(savedInventario, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    @Override
    public ResponseEntity<Inventario> updateObject(int id, Inventario inventario) {
        inventario.setId_producto(id);
        Inventario updatedInventario = inventarioService.updateObject(inventario);
        return new ResponseEntity<>(updatedInventario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteObject(int id) {
        inventarioService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
