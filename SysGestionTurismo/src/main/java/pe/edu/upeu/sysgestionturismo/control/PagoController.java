package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.dtos.CrearPagoDto;
import pe.edu.upeu.sysgestionturismo.dtos.PagoDto;
import pe.edu.upeu.sysgestionturismo.servicio.IPagoService;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    @PostMapping("/crear")
    public ResponseEntity<PagoDto> crear(@RequestBody CrearPagoDto request) {
        return ResponseEntity.ok(pagoService.crearPago(request));
    }

    @PostMapping("/{id}/comprobante")
    public ResponseEntity<PagoDto> subirComprobante(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(pagoService.subirComprobante(id, file));
    }

    @PostMapping("/{id}/confirmar")
    public ResponseEntity<PagoDto> confirmar(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.confirmarPago(id));
    }
}
