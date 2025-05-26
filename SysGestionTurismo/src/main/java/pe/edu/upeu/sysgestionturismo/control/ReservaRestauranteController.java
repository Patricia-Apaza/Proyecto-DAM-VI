package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaRestauranteDto;
import pe.edu.upeu.sysgestionturismo.mappers.ReservaRestauranteMapper;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaRestaurante;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaRestauranteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservarestaurante")
@CrossOrigin(origins = "*")
public class ReservaRestauranteController {

    @Autowired
    private IReservaRestauranteService reservaRestauranteService;

    @GetMapping("/listar")
    public List<ReservaRestauranteDto> listar() {
        List<ReservaRestaurante> lista = reservaRestauranteService.findAll();
        return lista.stream().map(ReservaRestauranteMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public ReservaRestauranteDto guardar(@RequestBody ReservaRestauranteDto dto) {
        ReservaRestaurante entidad = ReservaRestauranteMapper.toEntity(dto);
        ReservaRestaurante guardado = reservaRestauranteService.save(entidad);
        return ReservaRestauranteMapper.toDto(guardado);
    }

    @PutMapping("/editar")
    public ReservaRestauranteDto editar(@RequestBody ReservaRestauranteDto dto) {
        ReservaRestaurante entidad = ReservaRestauranteMapper.toEntity(dto);
        ReservaRestaurante actualizado = reservaRestauranteService.update(entidad);
        return ReservaRestauranteMapper.toDto(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaRestauranteService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public ReservaRestauranteDto buscar(@PathVariable Long id) {
        ReservaRestaurante entidad = reservaRestauranteService.findById(id);
        return entidad != null ? ReservaRestauranteMapper.toDto(entidad) : null;
    }
}
