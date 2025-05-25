package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaActividadDto;
import pe.edu.upeu.sysgestionturismo.mappers.ReservaActividadMapper;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaActividad;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaActividadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservaactividad")
@CrossOrigin(origins = "*")
public class ReservaActividadController {

    @Autowired
    private IReservaActividadService reservaActividadService;

    @GetMapping("/listar")
    public List<ReservaActividadDto> listar() {
        List<ReservaActividad> lista = reservaActividadService.findAll();
        return lista.stream().map(ReservaActividadMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public ReservaActividadDto guardar(@RequestBody ReservaActividadDto dto) {
        ReservaActividad entidad = ReservaActividadMapper.toEntity(dto);
        ReservaActividad guardado = reservaActividadService.save(entidad);
        return ReservaActividadMapper.toDto(guardado);
    }

    @PutMapping("/editar")
    public ReservaActividadDto editar(@RequestBody ReservaActividadDto dto) {
        ReservaActividad entidad = ReservaActividadMapper.toEntity(dto);
        ReservaActividad actualizado = reservaActividadService.update(entidad);
        return ReservaActividadMapper.toDto(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaActividadService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public ReservaActividadDto buscar(@PathVariable Long id) {
        ReservaActividad entidad = reservaActividadService.findById(id);
        return entidad != null ? ReservaActividadMapper.toDto(entidad) : null;
    }
}