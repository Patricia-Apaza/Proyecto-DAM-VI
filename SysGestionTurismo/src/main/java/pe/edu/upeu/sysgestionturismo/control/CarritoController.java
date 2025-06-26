package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.AgregarCarritoDto;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoDto;
import pe.edu.upeu.sysgestionturismo.servicio.ICarritoService;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    @Autowired
    private ICarritoService carritoService;

    @PostMapping("/agregar")
    public CarritoDto agregarAlCarrito(@RequestBody AgregarCarritoDto dto) {
        return carritoService.agregarAlCarrito(dto);
    }
}
