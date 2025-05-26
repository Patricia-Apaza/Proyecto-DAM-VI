package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioRestauranteDto;
import pe.edu.upeu.sysgestionturismo.mappers.InventarioRestauranteMapper;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioRestaurante;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioRestauranteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventario-restaurante")
@CrossOrigin(origins = "*")
public class InventarioRestauranteController {

    @Autowired
    private IInventarioRestauranteService service;

    @GetMapping("/listar")
    public List<InventarioRestauranteDto> listar() {
        return service.findAll().stream().map(InventarioRestauranteMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public InventarioRestauranteDto guardar(@RequestBody InventarioRestauranteDto dto) {
        InventarioRestaurante inv = service.save(InventarioRestauranteMapper.toEntity(dto));
        return InventarioRestauranteMapper.toDto(inv);
    }

    @PutMapping("/editar")
    public InventarioRestauranteDto editar(@RequestBody InventarioRestauranteDto dto) {
        InventarioRestaurante inv = service.update(InventarioRestauranteMapper.toEntity(dto));
        return InventarioRestauranteMapper.toDto(inv);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public InventarioRestauranteDto buscar(@PathVariable Long id) {
        return InventarioRestauranteMapper.toDto(service.findById(id));
    }
}
