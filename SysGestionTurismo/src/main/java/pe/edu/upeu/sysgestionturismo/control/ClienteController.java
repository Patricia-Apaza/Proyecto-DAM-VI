package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import pe.edu.upeu.sysgestionturismo.dtos.ClienteDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public ClienteDTO registrarCliente(@RequestBody ClienteDTO dto) {
        return clienteService.registrarCliente(dto);
    }
}