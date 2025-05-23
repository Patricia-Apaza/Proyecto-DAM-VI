package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaDto;
import pe.edu.upeu.sysgestionturismo.mappers.ReservaMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @GetMapping("/listar")
    public List<ReservaDto> listar() {
        return reservaService.findAll().stream()
                .map(ReservaMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public ReservaDto guardar(@RequestBody ReservaDto reservaDto) {
        Reserva reserva = ReservaMapper.toEntity(reservaDto);
        Reserva savedReserva = reservaService.save(reserva);
        return ReservaMapper.toDto(savedReserva);
    }

    @PutMapping("/editar")
    public ReservaDto editar(@RequestBody ReservaDto reservaDto) {
        Reserva reserva = ReservaMapper.toEntity(reservaDto);
        Reserva updatedReserva = reservaService.update(reserva);
        return ReservaMapper.toDto(updatedReserva);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public ReservaDto buscar(@PathVariable Long id) {
        Reserva reserva = reservaService.findById(id);
        return ReservaMapper.toDto(reserva);
    }
}