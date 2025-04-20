package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.ClienteDTO;
import java.util.List;

public interface IClienteService {

    List<ClienteDTO> obtenerTodosLosClientes();

    ClienteDTO obtenerClientePorId(Long id);

    ClienteDTO registrarCliente(ClienteDTO clienteDTO);

    ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO);

    void eliminarCliente(Long id);

    List<ClienteDTO> listarClientes();
}