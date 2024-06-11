package es.fit.femme.model.controller;

import es.fit.femme.business.entities.Categoria;
import es.fit.femme.model.dto.CategoriaDTO;
import es.fit.femme.model.mapper.CategoriaMapper;
import es.fit.femme.model.services.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private ICategoriaService categoriaService;

    @Autowired
    public void setCategoriaService(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);

        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            CategoriaDTO categoriaDTO = CategoriaMapper.toDto(categoria);
            return ResponseEntity.ok(categoriaDTO);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<CategoriaDTO> categoriaDTOList = categoriaService.getAllObjects().stream().map(CategoriaMapper::toDto).toList();
        return ResponseEntity.ok(categoriaDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoriaDTO categoriaDTO) {
        if (categoriaDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        categoriaService.saveObject(CategoriaMapper.toEntity(categoriaDTO));

        try {
            return ResponseEntity.created(new URI("/categoria/save")).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCategoria (@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if(categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            categoria.setNombre(categoriaDTO.getNombre());
            categoria.setDescripcion(categoriaDTO.getDescripcion());
            categoriaService.saveObject(categoria);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            categoriaService.deleteObject(id);
            return ResponseEntity.ok("Registro eliminado con éxito");
        }
        return ResponseEntity.badRequest().build();
    }

}
