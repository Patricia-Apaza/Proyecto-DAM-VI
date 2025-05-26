package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioHospedajeDto;
import pe.edu.upeu.sysgestionturismo.mappers.InventarioHospedajeMapper;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioHospedaje;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioHospedajeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventario-hospedaje")
@CrossOrigin(origins = "*")
public class InventarioHospedajeController {

    @Autowired
    private IInventarioHospedajeService service;

    @GetMapping("/listar")
    public List<InventarioHospedajeDto> listar() {
        return service.findAll().stream().map(InventarioHospedajeMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public InventarioHospedajeDto guardar(@RequestBody InventarioHospedajeDto dto) {
        InventarioHospedaje inv = service.save(InventarioHospedajeMapper.toEntity(dto));
        return InventarioHospedajeMapper.toDto(inv);
    }

    @PutMapping("/editar")
    public InventarioHospedajeDto editar(@RequestBody InventarioHospedajeDto dto) {
        InventarioHospedaje inv = service.update(InventarioHospedajeMapper.toEntity(dto));
        return InventarioHospedajeMapper.toDto(inv);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public InventarioHospedajeDto buscar(@PathVariable Long id) {
        return InventarioHospedajeMapper.toDto(service.findById(id));
    }
}
