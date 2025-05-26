package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteRestauranteDto;
import pe.edu.upeu.sysgestionturismo.mappers.PaqueteRestauranteMapper;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteRestaurante;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteRestauranteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paquete-restaurante")
@CrossOrigin(origins = "*")
public class PaqueteRestauranteController {

    @Autowired
    private IPaqueteRestauranteService service;

    @GetMapping("/listar")
    public List<PaqueteRestauranteDto> listar() {
        return service.findAll().stream()
                .map(PaqueteRestauranteMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public PaqueteRestauranteDto guardar(@RequestBody PaqueteRestauranteDto dto) {
        PaqueteRestaurante entity = PaqueteRestauranteMapper.toEntity(dto);
        return PaqueteRestauranteMapper.toDto(service.save(entity));
    }

    @PutMapping("/editar")
    public PaqueteRestauranteDto editar(@RequestBody PaqueteRestauranteDto dto) {
        PaqueteRestaurante entity = PaqueteRestauranteMapper.toEntity(dto);
        return PaqueteRestauranteMapper.toDto(service.update(entity));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public PaqueteRestauranteDto buscar(@PathVariable Long id) {
        PaqueteRestaurante entity = service.findById(id);
        return entity != null ? PaqueteRestauranteMapper.toDto(entity) : null;
    }
}
