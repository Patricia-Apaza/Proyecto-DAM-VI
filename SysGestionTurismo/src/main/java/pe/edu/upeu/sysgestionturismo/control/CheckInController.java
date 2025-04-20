package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.servicio.ICheckInService;

@RestController
@RequestMapping("/api/checkin")
public class CheckInController {

    @Autowired
    private ICheckInService checkInService;

    @PostMapping("/{clienteId}")
    public String registrarCheckIn(@PathVariable Long clienteId) {
        return checkInService.realizarCheckIn(clienteId);
    }
}