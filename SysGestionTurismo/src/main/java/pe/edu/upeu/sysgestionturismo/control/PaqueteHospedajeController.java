package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteHospedajeDto;
import pe.edu.upeu.sysgestionturismo.mappers.PaqueteHospedajeMapper;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteHospedaje;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteHospedajeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paquete-hospedaje")
@CrossOrigin(origins = "*")
public class PaqueteHospedajeController {

    @Autowired
    private IPaqueteHospedajeService service;

    @GetMapping("/listar")
    public List<PaqueteHospedajeDto> listar() {
        return service.findAll().stream()
                .map(PaqueteHospedajeMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public PaqueteHospedajeDto guardar(@RequestBody PaqueteHospedajeDto dto) {
        PaqueteHospedaje entity = PaqueteHospedajeMapper.toEntity(dto);
        return PaqueteHospedajeMapper.toDto(service.save(entity));
    }

    @PutMapping("/editar")
    public PaqueteHospedajeDto editar(@RequestBody PaqueteHospedajeDto dto) {
        PaqueteHospedaje entity = PaqueteHospedajeMapper.toEntity(dto);
        return PaqueteHospedajeMapper.toDto(service.update(entity));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public PaqueteHospedajeDto buscar(@PathVariable Long id) {
        PaqueteHospedaje entity = service.findById(id);
        return entity != null ? PaqueteHospedajeMapper.toDto(entity) : null;
    }
}
