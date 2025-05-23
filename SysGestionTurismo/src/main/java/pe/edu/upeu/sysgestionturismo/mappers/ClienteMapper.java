package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ClienteDto;
import pe.edu.upeu.sysgestionturismo.modelo.Cliente;

public class ClienteMapper {

    public static ClienteDto toDto(Cliente cliente) {
        ClienteDto dto = new ClienteDto();
        dto.setIdCliente(cliente.getIdCliente());
        dto.setNombres(cliente.getNombres());
        dto.setApellidos(cliente.getApellidos());
        dto.setNumDocumento(cliente.getNumDocumento());
        dto.setImagenPerfil(cliente.getImagenPerfil());
        dto.setWhatsappContacto(cliente.getWhatsappContacto());
        dto.setCorreo(cliente.getCorreo());
        dto.setDireccion(cliente.getDireccion());
        dto.setTipoDocumento(cliente.getTipoDocumento()); // ← añadido
        return dto;
    }

    public static Cliente toEntity(ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(dto.getIdCliente());
        cliente.setNombres(dto.getNombres());
        cliente.setApellidos(dto.getApellidos());
        cliente.setNumDocumento(dto.getNumDocumento());
        cliente.setImagenPerfil(dto.getImagenPerfil());
        cliente.setWhatsappContacto(dto.getWhatsappContacto());
        cliente.setCorreo(dto.getCorreo());
        cliente.setDireccion(dto.getDireccion());
        cliente.setTipoDocumento(dto.getTipoDocumento()); // ← añadido
        return cliente;
    }
}