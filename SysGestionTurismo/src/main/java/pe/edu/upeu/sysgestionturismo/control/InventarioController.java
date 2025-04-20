package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioService;


import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {

    @Autowired
    private IInventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> listarInventarios() {
        return ResponseEntity.ok(inventarioService.listarInventarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> obtenerInventarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.obtenerInventarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<InventarioDTO> registrarInventario(@RequestBody InventarioDTO dto) {
        return ResponseEntity.ok(inventarioService.registrarInventario(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> actualizarInventario(@PathVariable Long id, @RequestBody InventarioDTO dto) {
        return ResponseEntity.ok(inventarioService.actualizarInventario(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable Long id) {
        inventarioService.eliminarInventario(id);
        return ResponseEntity.noContent().build();
    }
}