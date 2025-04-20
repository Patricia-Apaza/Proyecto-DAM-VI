package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.HospedajeDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IHospedajeService;


import java.util.List;

@RestController
@RequestMapping("/api/hospedajes")
public class HospedajeController {

    @Autowired
    private IHospedajeService hospedajeService;

    @GetMapping
    public ResponseEntity<List<HospedajeDTO>> listarHospedajes() {
        return ResponseEntity.ok(hospedajeService.listarHospedajes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospedajeDTO> obtenerHospedajePorId(@PathVariable Long id) {
        return ResponseEntity.ok(hospedajeService.obtenerHospedajePorId(id));
    }

    @PostMapping
    public ResponseEntity<HospedajeDTO> registrarHospedaje(@RequestBody HospedajeDTO dto) {
        return ResponseEntity.ok(hospedajeService.registrarHospedaje(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospedajeDTO> actualizarHospedaje(@PathVariable Long id, @RequestBody HospedajeDTO dto) {
        return ResponseEntity.ok(hospedajeService.actualizarHospedaje(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHospedaje(@PathVariable Long id) {
        hospedajeService.eliminarHospedaje(id);
        return ResponseEntity.noContent().build();
    }
}