package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.modelo.NivelPaquete;
import pe.edu.upeu.sysgestionturismo.servicio.INivelPaqueteService;

import java.util.List;

@RestController
@RequestMapping("/api/nivel-paquete")
@CrossOrigin(origins = "*")
public class NivelPaqueteController {

    @Autowired
    private INivelPaqueteService nivelPaqueteService;

    @GetMapping("/listar")
    public List<NivelPaquete> listar() {
        return nivelPaqueteService.findAll();
    }

    @PostMapping("/guardar")
    public NivelPaquete guardar(@RequestBody NivelPaquete nivelPaquete) {
        return nivelPaqueteService.save(nivelPaquete);
    }

    @PutMapping("/editar")
    public NivelPaquete editar(@RequestBody NivelPaquete nivelPaquete) {
        return nivelPaqueteService.update(nivelPaquete);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        nivelPaqueteService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public NivelPaquete buscar(@PathVariable Long id) {
        return nivelPaqueteService.findById(id);
    }
}
