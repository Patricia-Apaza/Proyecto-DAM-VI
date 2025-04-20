package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.ClienteDTO;
import pe.edu.upeu.sysgestionturismo.mappers.ClienteMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Cliente;
import pe.edu.upeu.sysgestionturismo.repositorio.IClienteRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IClienteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteDTO> listarClientes() {
        return obtenerTodosLosClientes();
    }

    @Override
    public List<ClienteDTO> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::toClienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO obtenerClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return clienteMapper.toClienteDTO(cliente);
    }

    @Override
    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toCliente(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteMapper.toClienteDTO(clienteGuardado);
    }

    @Override
    public ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Actualizamos el cliente con la información del DTO
        clienteMapper.updateEntityFromDto(clienteDTO, clienteExistente);

        // Guardamos el cliente actualizado
        Cliente clienteActualizado = clienteRepository.save(clienteExistente);

        // Convertimos el Cliente actualizado en un DTO para retornarlo
        return clienteMapper.toClienteDTO(clienteActualizado);
    }


    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}