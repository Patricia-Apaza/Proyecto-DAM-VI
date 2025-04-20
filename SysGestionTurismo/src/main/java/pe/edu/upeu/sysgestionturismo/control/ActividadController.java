package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ActividadDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IActividadService;


import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    @Autowired
    private IActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<ActividadDTO>> listarActividades() {
        return ResponseEntity.ok(actividadService.obtenerTodasLasActividades());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> obtenerActividadPorId(@PathVariable Long id) {
        return actividadService.obtenerActividadPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ActividadDTO> registrarActividad(@RequestBody ActividadDTO dto) {
        return ResponseEntity.ok(actividadService.registrarActividad(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadDTO> actualizarActividad(@PathVariable Long id, @RequestBody ActividadDTO dto) {
        return ResponseEntity.ok(actividadService.actualizarActividad(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarActividad(@PathVariable Long id) {
        actividadService.eliminarActividad(id);
        return ResponseEntity.noContent().build();
    }
}