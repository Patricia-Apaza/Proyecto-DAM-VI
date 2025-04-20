package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.PagoDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IPagoService;


import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    // Obtener todos los pagos
    @GetMapping
    public ResponseEntity<List<PagoDTO>> obtenerTodosLosPagos() {
        return ResponseEntity.ok(pagoService.obtenerTodosLosPagos());
    }

    // Obtener pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> obtenerPagoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtenerPagoPorId(id));
    }

    // Registrar un nuevo pago
    @PostMapping
    public ResponseEntity<PagoDTO> registrarPago(@RequestBody PagoDTO pagoDTO) {
        return new ResponseEntity<>(pagoService.registrarPago(pagoDTO), HttpStatus.CREATED);
    }

    // Actualizar un pago existente
    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> actualizarPago(@PathVariable Long id, @RequestBody PagoDTO pagoDTO) {
        return ResponseEntity.ok(pagoService.actualizarPago(id, pagoDTO));
    }

    // Eliminar un pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }

    // Procesar pago (puede incluir validación para VISA, Yape, Plin)
    @PostMapping("/procesar")
    public ResponseEntity<String> procesarPago(@RequestBody PagoDTO pagoDTO) {
        String mensaje = pagoService.procesarPago(pagoDTO);
        return ResponseEntity.ok(mensaje);
    }
}