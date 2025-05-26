package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaMenuDto;
import pe.edu.upeu.sysgestionturismo.mappers.ReservaMenuMapper;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaMenu;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaMenuService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservamenu")
@CrossOrigin(origins = "*")
public class ReservaMenuController {

    @Autowired
    private IReservaMenuService reservaMenuService;

    @GetMapping("/listar")
    public List<ReservaMenuDto> listar() {
        List<ReservaMenu> lista = reservaMenuService.findAll();
        return lista.stream().map(ReservaMenuMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public ReservaMenuDto guardar(@RequestBody ReservaMenuDto dto) {
        ReservaMenu entidad = ReservaMenuMapper.toEntity(dto);
        ReservaMenu guardado = reservaMenuService.save(entidad);
        return ReservaMenuMapper.toDto(guardado);
    }

    @PutMapping("/editar")
    public ReservaMenuDto editar(@RequestBody ReservaMenuDto dto) {
        ReservaMenu entidad = ReservaMenuMapper.toEntity(dto);
        ReservaMenu actualizado = reservaMenuService.update(entidad);
        return ReservaMenuMapper.toDto(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaMenuService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public ReservaMenuDto buscar(@PathVariable Long id) {
        ReservaMenu entidad = reservaMenuService.findById(id);
        return entidad != null ? ReservaMenuMapper.toDto(entidad) : null;
    }
}
