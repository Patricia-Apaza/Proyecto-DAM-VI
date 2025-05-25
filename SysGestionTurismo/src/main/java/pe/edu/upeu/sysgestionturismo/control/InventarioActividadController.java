package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioActividadDto;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioActividadService;

import java.util.List;

@RestController
@RequestMapping("/api/inventarioactividad")
public class InventarioActividadController {

    @Autowired
    private IInventarioActividadService service;

    @GetMapping
    public ResponseEntity<List<InventarioActividadDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioActividadDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<InventarioActividadDto> create(@RequestBody InventarioActividadDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioActividadDto> update(@PathVariable Long id, @RequestBody InventarioActividadDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
