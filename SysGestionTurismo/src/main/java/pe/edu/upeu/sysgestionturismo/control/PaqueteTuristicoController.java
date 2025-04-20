package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteTuristicoService;


import java.util.List;

@RestController
@RequestMapping("/api/paquetes-turisticos")
public class PaqueteTuristicoController {

    @Autowired
    private IPaqueteTuristicoService paqueteTuristicoService;

    // Obtener todos los paquetes turísticos
    @GetMapping
    public ResponseEntity<List<PaqueteTuristicoDTO>> obtenerTodosLosPaquetes() {
        return ResponseEntity.ok(paqueteTuristicoService.listarPaquetes());
    }

    // Obtener paquete turístico por ID
    @GetMapping("/{id}")
    public ResponseEntity<PaqueteTuristicoDTO> obtenerPaquetePorId(@PathVariable Long id) {
        return ResponseEntity.ok(paqueteTuristicoService.obtenerPaquetePorId(id));
    }

    // Registrar un nuevo paquete turístico
    @PostMapping
    public ResponseEntity<PaqueteTuristicoDTO> registrarPaquete(@RequestBody PaqueteTuristicoDTO paqueteTuristicoDTO) {
        return new ResponseEntity<>(paqueteTuristicoService.registrarPaqueteTuristico(paqueteTuristicoDTO), HttpStatus.CREATED);
    }

    // Actualizar un paquete turístico existente
    @PutMapping("/{id}")
    public ResponseEntity<PaqueteTuristicoDTO> actualizarPaquete(@PathVariable Long id, @RequestBody PaqueteTuristicoDTO paqueteTuristicoDTO) {
        return ResponseEntity.ok(paqueteTuristicoService.actualizarPaqueteTuristico(id, paqueteTuristicoDTO));
    }

    // Eliminar un paquete turístico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaquete(@PathVariable Long id) {
        paqueteTuristicoService.eliminarPaqueteTuristico(id);
        return ResponseEntity.noContent().build();
    }
}