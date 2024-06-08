package es.fitfemme.vista.controller;

import es.fitfemme.modelo.services.UsuarioService;
import es.fitfemme.negocio.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController implements ICrudControllerJpa<Usuario>{
    private UsuarioService usuarioService;

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    @Override
    public List<Usuario> getAllObjects() {
        return usuarioService.getAllObjects();
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<Usuario> saveObject(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.updateObject(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    @Override
    public ResponseEntity<Usuario> updateObject(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId_usuario(id);
        Usuario updatedUsuario = usuarioService.updateObject(usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteObject(@PathVariable int id) {
        usuarioService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
