package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaNinosDto;
import pe.edu.upeu.sysgestionturismo.mappers.ReservaNinosMapper;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaNinos;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaNinosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservaninos")
@CrossOrigin(origins = "*")
public class ReservaNinosController {

    @Autowired
    private IReservaNinosService reservaNinosService;

    @GetMapping("/listar")
    public List<ReservaNinosDto> listar() {
        return reservaNinosService.findAll().stream()
                .map(ReservaNinosMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public ReservaNinosDto guardar(@RequestBody ReservaNinosDto dto) {
        ReservaNinos entidad = ReservaNinosMapper.toEntity(dto);
        ReservaNinos guardado = reservaNinosService.save(entidad);
        return ReservaNinosMapper.toDto(guardado);
    }

    @PutMapping("/editar")
    public ReservaNinosDto editar(@RequestBody ReservaNinosDto dto) {
        ReservaNinos entidad = ReservaNinosMapper.toEntity(dto);
        ReservaNinos actualizado = reservaNinosService.update(entidad);
        return ReservaNinosMapper.toDto(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaNinosService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public ReservaNinosDto buscar(@PathVariable Long id) {
        ReservaNinos entidad = reservaNinosService.findById(id);
        return entidad != null ? ReservaNinosMapper.toDto(entidad) : null;
    }
}
