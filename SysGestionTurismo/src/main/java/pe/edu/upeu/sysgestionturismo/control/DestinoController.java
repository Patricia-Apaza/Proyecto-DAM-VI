package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upeu.sysgestionturismo.dtos.DestinoDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IDestinoService;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    @Autowired
    private IDestinoService destinoService;

    @GetMapping
    public ResponseEntity<List<DestinoDTO>> listarDestinos() {
        return ResponseEntity.ok(destinoService.listarDestinos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinoDTO> obtenerDestinoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(destinoService.obtenerDestinoPorId(id));
    }

    @PostMapping
    public ResponseEntity<DestinoDTO> registrarDestino(@RequestBody DestinoDTO dto) {
        return ResponseEntity.ok(destinoService.registrarDestino(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinoDTO> actualizarDestino(@PathVariable Long id, @RequestBody DestinoDTO dto) {
        return ResponseEntity.ok(destinoService.actualizarDestino(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDestino(@PathVariable Long id) {
        destinoService.eliminarDestino(id);
        return ResponseEntity.noContent().build();
    }
}