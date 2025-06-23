package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.modelo.Usuario;
import pe.edu.upeu.sysgestionturismo.servicio.IUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    // Solo ADMIN puede listar todos los usuarios
    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    // Solo ADMIN puede crear usuarios
    @PostMapping("/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    // Solo ADMIN puede editar usuarios
    @PutMapping("/editar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    // Solo ADMIN puede eliminar usuarios
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Solo ADMIN puede buscar usuarios por ID
    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    // Endpoint para que CLIENTE vea su propio perfil
    @GetMapping("/perfil")
    @PreAuthorize("hasRole('CLIENTE') or hasRole('ADMIN')")
    public ResponseEntity<Usuario> verPerfil(Authentication authentication) {
        String correo = authentication.getName();
        Usuario usuario = usuarioService.findByCorreo(correo);
        return ResponseEntity.ok(usuario);
    }
}
