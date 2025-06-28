package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.AgregarCarritoDto;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoDetalleDto;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoDto;
import pe.edu.upeu.sysgestionturismo.mappers.CarritoDetalleMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Carrito;
import pe.edu.upeu.sysgestionturismo.repositorio.CarritoRepository;
import pe.edu.upeu.sysgestionturismo.servicio.ICarritoService;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    @Autowired
    private ICarritoService carritoService;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private CarritoDetalleMapper carritoDetalleMapper;

    @PostMapping("/agregar")
    public CarritoDto agregarAlCarrito(@RequestBody AgregarCarritoDto dto) {
        return carritoService.agregarAlCarrito(dto);
    }

    @GetMapping("/{idCarrito}")
    public ResponseEntity<CarritoDetalleDto> obtener(@PathVariable Long idCarrito) {
        var carrito = carritoRepository.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        return ResponseEntity.ok(carritoDetalleMapper.toDto(carrito));
    }
}
