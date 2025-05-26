package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaPaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.mappers.ReservaPaqueteTuristicoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaPaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaPaqueteTuristicoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservapaqueteturistico")
@CrossOrigin(origins = "*")
public class ReservaPaqueteTuristicoController {

    @Autowired
    private IReservaPaqueteTuristicoService service;

    @GetMapping("/listar")
    public List<ReservaPaqueteTuristicoDto> listar() {
        return service.findAll().stream()
                .map(ReservaPaqueteTuristicoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public ReservaPaqueteTuristicoDto guardar(@RequestBody ReservaPaqueteTuristicoDto dto) {
        ReservaPaqueteTuristico entidad = ReservaPaqueteTuristicoMapper.toEntity(dto);
        return ReservaPaqueteTuristicoMapper.toDto(service.save(entidad));
    }

    @PutMapping("/editar")
    public ReservaPaqueteTuristicoDto editar(@RequestBody ReservaPaqueteTuristicoDto dto) {
        ReservaPaqueteTuristico entidad = ReservaPaqueteTuristicoMapper.toEntity(dto);
        return ReservaPaqueteTuristicoMapper.toDto(service.update(entidad));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public ReservaPaqueteTuristicoDto buscar(@PathVariable Long id) {
        ReservaPaqueteTuristico entidad = service.findById(id);
        return entidad != null ? ReservaPaqueteTuristicoMapper.toDto(entidad) : null;
    }
}
