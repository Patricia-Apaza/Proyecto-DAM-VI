package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioPaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.mappers.InventarioPaqueteTuristicoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioPaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioPaqueteTuristicoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventario-paquete-turistico")
@CrossOrigin(origins = "*")
public class InventarioPaqueteTuristicoController {

    @Autowired
    private IInventarioPaqueteTuristicoService service;

    @GetMapping("/listar")
    public List<InventarioPaqueteTuristicoDto> listar() {
        return service.findAll().stream().map(InventarioPaqueteTuristicoMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public InventarioPaqueteTuristicoDto guardar(@RequestBody InventarioPaqueteTuristicoDto dto) {
        InventarioPaqueteTuristico inv = service.save(InventarioPaqueteTuristicoMapper.toEntity(dto));
        return InventarioPaqueteTuristicoMapper.toDto(inv);
    }

    @PutMapping("/editar")
    public InventarioPaqueteTuristicoDto editar(@RequestBody InventarioPaqueteTuristicoDto dto) {
        InventarioPaqueteTuristico inv = service.update(InventarioPaqueteTuristicoMapper.toEntity(dto));
        return InventarioPaqueteTuristicoMapper.toDto(inv);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public InventarioPaqueteTuristicoDto buscar(@PathVariable Long id) {
        return InventarioPaqueteTuristicoMapper.toDto(service.findById(id));
    }
}
