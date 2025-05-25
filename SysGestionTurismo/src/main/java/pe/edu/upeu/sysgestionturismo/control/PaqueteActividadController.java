package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteActividadDto;
import pe.edu.upeu.sysgestionturismo.mappers.PaqueteActividadMapper;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteActividad;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteActividadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paquete-actividad")
@CrossOrigin(origins = "*")
public class PaqueteActividadController {

    @Autowired
    private IPaqueteActividadService service;

    @GetMapping("/listar")
    public List<PaqueteActividadDto> listar() {
        return service.findAll().stream()
                .map(PaqueteActividadMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public PaqueteActividadDto guardar(@RequestBody PaqueteActividadDto dto) {
        PaqueteActividad entity = PaqueteActividadMapper.toEntity(dto);
        return PaqueteActividadMapper.toDto(service.save(entity));
    }

    @PutMapping("/editar")
    public PaqueteActividadDto editar(@RequestBody PaqueteActividadDto dto) {
        PaqueteActividad entity = PaqueteActividadMapper.toEntity(dto);
        return PaqueteActividadMapper.toDto(service.update(entity));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public PaqueteActividadDto buscar(@PathVariable Long id) {
        PaqueteActividad entity = service.findById(id);
        return entity != null ? PaqueteActividadMapper.toDto(entity) : null;
    }
}
