package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.PedidoService;
import es.fitfemme.negocio.entities.Inventario;
import es.fitfemme.negocio.entities.Pedido;
import es.fitfemme.negocio.entities.Producto;
import es.fitfemme.vista.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController implements ICrudControllerJpa<Pedido>{

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/")
    @Override
    public List<Pedido> getAllObjects() {
        return pedidoService.getAllObjects();
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<Pedido> saveObject(@RequestBody Pedido pedido) {
        Pedido savedPedido = pedidoService.saveObject(pedido);
        return new ResponseEntity<>(savedPedido, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    @Override
    public ResponseEntity<Pedido> updateObject(@PathVariable int id, @RequestBody Pedido pedido) {
        pedido.setId_pedido(id);
        Pedido updatedPedido = pedidoService.updateObject(pedido);
        return new ResponseEntity<>(updatedPedido, HttpStatus.OK);
    }

    @DeleteMapping("borrar/{id}")
    @Override
    public ResponseEntity<Void> deleteObject(@PathVariable int id) {
        pedidoService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
