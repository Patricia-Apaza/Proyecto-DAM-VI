package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.servicio.ICheckOutService;

@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {

    @Autowired
    private ICheckOutService checkOutService;

    @PostMapping("/{clienteId}")
    public String registrarCheckOut(@PathVariable Long clienteId) {
        return checkOutService.realizarCheckOut(clienteId);
    }
}