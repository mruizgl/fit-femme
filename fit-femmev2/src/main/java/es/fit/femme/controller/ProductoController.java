package es.fit.femme.controller;

import es.fit.femme.model.entities.Producto;
import es.fit.femme.model.dto.ProductoDTO;
import es.fit.femme.model.mapper.ProductoMapper;
import es.fit.femme.services.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private IProductoService productoService;

    @Autowired
    public void setProductoService(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.findById(id);

        if(productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            ProductoDTO productoDTO = ProductoMapper.toDto(producto);

            return  ResponseEntity.ok(productoDTO);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<ProductoDTO> productoDTOS = productoService.getAllObjects().stream().map(ProductoMapper::toDto).toList();
        return ResponseEntity.ok(productoDTOS);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {
        if (productoDTO.getNombre().isBlank() ||  productoDTO.getCategoria() == null || productoDTO.getPrecio() == null) {
            return ResponseEntity.badRequest().build();
        }
        Producto producto = ProductoMapper.toEntity(productoDTO);
        productoService.saveObject(producto);

        return ResponseEntity.created( new URI("/producto/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        Optional<Producto> productoOptional = productoService.findById(id);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(producto.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setCategoria(productoDTO.getCategoria());
            productoService.saveObject(producto);
            return  ResponseEntity.ok("Registro actualizado con éxito");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (id != null) {
            if(productoOptional.isPresent()) {
                productoService.deleteObject(id);
                return ResponseEntity.ok("Registro eliminado con éxito");
            }

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
