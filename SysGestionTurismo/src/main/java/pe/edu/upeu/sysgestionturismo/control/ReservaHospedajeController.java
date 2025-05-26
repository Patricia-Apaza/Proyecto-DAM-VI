package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaHospedajeDto;
import pe.edu.upeu.sysgestionturismo.mappers.ReservaHospedajeMapper;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaHospedaje;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaHospedajeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservahospedaje")
@CrossOrigin(origins = "*")
public class ReservaHospedajeController {

    @Autowired
    private IReservaHospedajeService reservaHospedajeService;

    @GetMapping("/listar")
    public List<ReservaHospedajeDto> listar() {
        return reservaHospedajeService.findAll().stream()
                .map(ReservaHospedajeMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public ReservaHospedajeDto guardar(@RequestBody ReservaHospedajeDto dto) {
        ReservaHospedaje entidad = ReservaHospedajeMapper.toEntity(dto);
        ReservaHospedaje guardado = reservaHospedajeService.save(entidad);
        return ReservaHospedajeMapper.toDto(guardado);
    }

    @PutMapping("/editar")
    public ReservaHospedajeDto editar(@RequestBody ReservaHospedajeDto dto) {
        ReservaHospedaje entidad = ReservaHospedajeMapper.toEntity(dto);
        ReservaHospedaje actualizado = reservaHospedajeService.update(entidad);
        return ReservaHospedajeMapper.toDto(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaHospedajeService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public ReservaHospedajeDto buscar(@PathVariable Long id) {
        ReservaHospedaje entidad = reservaHospedajeService.findById(id);
        return entidad != null ? ReservaHospedajeMapper.toDto(entidad) : null;
    }
}
