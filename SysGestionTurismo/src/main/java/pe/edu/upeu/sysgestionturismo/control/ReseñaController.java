package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ReseñaDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IReseñaService;


import java.util.List;

@RestController
@RequestMapping("/api/resenas")
public class ReseñaController {

    @Autowired
    private IReseñaService reseñaService;

    // Obtener todas las reseñas
    @GetMapping
    public ResponseEntity<List<ReseñaDTO>> obtenerTodasLasReseñas() {
        return ResponseEntity.ok(reseñaService.obtenerTodasLasReseñas());
    }

    // Obtener reseña por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReseñaDTO> obtenerReseñaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reseñaService.obtenerReseñaPorId(id));
    }

    // Registrar una nueva reseña
    @PostMapping
    public ResponseEntity<ReseñaDTO> registrarReseña(@RequestBody ReseñaDTO reseñaDTO) {
        return new ResponseEntity<>(reseñaService.registrarReseña(reseñaDTO), HttpStatus.CREATED);
    }

    // Actualizar una reseña existente
    @PutMapping("/{id}")
    public ResponseEntity<ReseñaDTO> actualizarReseña(@PathVariable Long id, @RequestBody ReseñaDTO reseñaDTO) {
        return ResponseEntity.ok(reseñaService.actualizarReseña(id, reseñaDTO));
    }

    // Eliminar una reseña
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReseña(@PathVariable Long id) {
        reseñaService.eliminarReseña(id);
        return ResponseEntity.noContent().build();
    }
}
