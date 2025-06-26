package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoItemDto;
import pe.edu.upeu.sysgestionturismo.servicio.ICarritoItemService;

import java.util.List;

@RestController
@RequestMapping("/api/carrito-item")
@CrossOrigin(origins = "*")
public class CarritoItemController {

    @Autowired
    private ICarritoItemService carritoItemService;

    @GetMapping("/listar/{idCarrito}")
    public List<CarritoItemDto> listarItemsPorCarrito(@PathVariable Long idCarrito) {
        return carritoItemService.listarPorCarrito(idCarrito);
    }

    @DeleteMapping("/eliminar/{idCarritoItem}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long idCarritoItem) {
        carritoItemService.eliminarItem(idCarritoItem);
        return ResponseEntity.noContent().build();
    }
}
