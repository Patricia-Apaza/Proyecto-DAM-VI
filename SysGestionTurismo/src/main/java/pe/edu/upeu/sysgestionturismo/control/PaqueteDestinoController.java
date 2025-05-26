package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteDestinoDto;
import pe.edu.upeu.sysgestionturismo.mappers.PaqueteDestinoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteDestino;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteDestinoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paquete-destino")
@CrossOrigin(origins = "*")
public class PaqueteDestinoController {

    @Autowired
    private IPaqueteDestinoService service;

    @GetMapping("/listar")
    public List<PaqueteDestinoDto> listar() {
        return service.findAll().stream()
                .map(PaqueteDestinoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public PaqueteDestinoDto guardar(@RequestBody PaqueteDestinoDto dto) {
        PaqueteDestino entity = PaqueteDestinoMapper.toEntity(dto);
        return PaqueteDestinoMapper.toDto(service.save(entity));
    }

    @PutMapping("/editar")
    public PaqueteDestinoDto editar(@RequestBody PaqueteDestinoDto dto) {
        PaqueteDestino entity = PaqueteDestinoMapper.toEntity(dto);
        return PaqueteDestinoMapper.toDto(service.update(entity));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public PaqueteDestinoDto buscar(@PathVariable Long id) {
        PaqueteDestino entity = service.findById(id);
        return entity != null ? PaqueteDestinoMapper.toDto(entity) : null;
    }
}
